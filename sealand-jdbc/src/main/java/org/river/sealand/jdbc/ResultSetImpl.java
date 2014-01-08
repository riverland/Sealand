package org.river.sealand.jdbc;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.river.sealand.jdbc.support.Field;
import org.river.sealand.jdbc.support.IResultHandler;
import org.river.sealand.proto.IProtoStream;
import org.river.sealand.proto.Message;
import org.river.sealand.proto.Oid;
import org.river.sealand.proto.ProtoUtils;
import org.river.sealand.utils.DateUtils;
import org.river.sealand.utils.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 返回结果集
 * 
 * @author river
 * @since Dec 28, 2013
 */
public class ResultSetImpl extends JdbcWrapper implements ResultSet, IResultHandler {
	private static final Logger log = LoggerFactory.getLogger(ResultSetImpl.class);
	// 元数据
	protected final int maxFieldSize;
	protected final int maxRows;
	protected final int queryTimeout;
	protected final int fetchSize;
	protected final int fetchDirection;
	private IProtoStream protoStream;
	private Charset charset;

	// 状态数据
	protected List<byte[][]> rows = new ArrayList<byte[][]>();
	protected int current_row = -1;
	protected int row_offset;
	protected byte[][] this_row;
	protected boolean wasNull = false;
	protected ResultSetMetaDataImpl metaData = new ResultSetMetaDataImpl();
	protected Object lock;
	protected boolean bufferCompleted = false;
	protected Status status = Status.NEW;
	private ReceiveThread rcvThread;

	public ResultSetImpl(int maxFieldSize, int maxRows, int queryTimeout, int fetchSize, int fetchDirection, IProtoStream protoStream) {
		this.maxFieldSize = maxFieldSize;
		this.maxRows = maxRows;
		this.queryTimeout = queryTimeout;
		this.fetchSize = fetchSize;
		this.fetchDirection = fetchDirection;
		this.protoStream = protoStream;
		this.rcvThread = new ReceiveThread();
		rcvThread.start();
	}

	@Override
	public void handleCommandStatus(String status, int updateCount) {

	}

	@Override
	public void handleWarning(SQLWarning warning) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleError(SQLException error) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleCompletion() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean next() throws SQLException {
		if (current_row == this.rows.size()) {
			if (this.bufferCompleted) {
				return false;
			} else {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					log.error(e.getLocalizedMessage());
					throw new SQLException(e);
				}
			}
		}

		current_row++;
		this_row = this.rows.get(current_row);
		return true;
	}

	@Override
	public void close() throws SQLException {
		byte[] closeMsg = ProtoUtils.pack4ResultSetClose();
		try {
			protoStream.send(closeMsg);
		} catch (IOException e) {
			log.error(e.getLocalizedMessage());
			throw new SQLException(e);
		} finally {
			this.rows = null;
			this.metaData = null;
			this.status = Status.CLOSED;
			this.rcvThread.alive = false;
		}
	}

	@Override
	public boolean wasNull() throws SQLException {
		return wasNull;
	}

	@Override
	public String getString(int columnIndex) throws SQLException {
		this.checkCollumn(columnIndex);
		if (wasNull) {
			return null;
		}

		if (this.isCollumnBin(columnIndex)) {
			Object obj = getObject(columnIndex, this.metaData.getFields().get(columnIndex - 1));
			if (obj == null) {
				return null;
			}
			return obj.toString();
		}

		return new String(this_row[columnIndex - 1], charset);
	}

	@Override
	public boolean getBoolean(int columnIndex) throws SQLException {
		this.checkCollumn(columnIndex);
		if (wasNull) {
			return false;
		}

		if (this.isCollumnBin(columnIndex)) {
			final int col = columnIndex - 1;
			long longValue = NumberUtils.readInt8(this_row[col]);
			if (longValue == 0) {
				return false;
			}

			String value = new String(this_row[col]);
			if (value.trim() == "") {
				return false;
			}

			return true;
		}

		String str = getString(columnIndex);
		return str != null && "true".equalsIgnoreCase(str.trim());
	}

	@Override
	public byte getByte(int columnIndex) throws SQLException {
		this.checkCollumn(columnIndex);
		if (wasNull) {
			return 0;
		}

		if (this.isCollumnBin(columnIndex)) {
			final int col = columnIndex - 1;
			return (byte) NumberUtils.readInt8(this_row[col]);
		}

		String str = this.getString(columnIndex);
		if (str == null || str.trim().equals("")) {
			return 0;
		}

		str = str.trim();
		try {
			return Byte.parseByte(str);
		} catch (NumberFormatException e) {
			throw new SQLException(e);
		}
	}

	@Override
	public short getShort(int columnIndex) throws SQLException {
		this.checkCollumn(columnIndex);
		if (wasNull) {
			return 0;
		}

		if (this.isCollumnBin(columnIndex)) {
			final int col = columnIndex - 1;
			return (short) NumberUtils.readInt8(this_row[col]);
		}

		String str = this.getString(columnIndex);
		if (str == null || str.trim().equals("")) {
			return 0;
		}

		str = str.trim();
		try {
			return Short.parseShort(str);
		} catch (NumberFormatException e) {
			throw new SQLException(e);
		}
	}

	@Override
	public int getInt(int columnIndex) throws SQLException {
		this.checkCollumn(columnIndex);
		if (wasNull) {
			return 0;
		}

		if (this.isCollumnBin(columnIndex)) {
			final int col = columnIndex - 1;
			return (int) NumberUtils.readInt8(this_row[col]);
		}

		String str = this.getString(columnIndex);
		if (str == null || str.trim().equals("")) {
			return 0;
		}

		str = str.trim();
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			throw new SQLException(e);
		}
	}

	@Override
	public long getLong(int columnIndex) throws SQLException {
		this.checkCollumn(columnIndex);
		if (wasNull) {
			return 0;
		}

		if (this.isCollumnBin(columnIndex)) {
			final int col = columnIndex - 1;
			return NumberUtils.readInt8(this_row[col]);
		}

		String str = this.getString(columnIndex);
		if (str == null || str.trim().equals("")) {
			return 0;
		}

		str = str.trim();
		try {
			return Long.parseLong(str);
		} catch (NumberFormatException e) {
			throw new SQLException(e);
		}
	}

	@Override
	public float getFloat(int columnIndex) throws SQLException {
		this.checkCollumn(columnIndex);
		if (wasNull) {
			return 0;
		}

		if (this.isCollumnBin(columnIndex)) {
			final int col = columnIndex - 1;
			int oid = this.metaData.getFields().get(col).getType().getOid();
			return (float) this.readFloat(this_row[col], oid);
		}

		String str = this.getString(columnIndex);
		if (str == null || str.trim().equals("")) {
			return 0;
		}

		str = str.trim();
		try {
			return Float.parseFloat(str);
		} catch (NumberFormatException e) {
			throw new SQLException(e);
		}
	}

	@Override
	public double getDouble(int columnIndex) throws SQLException {
		this.checkCollumn(columnIndex);
		if (wasNull) {
			return 0;
		}

		if (this.isCollumnBin(columnIndex)) {
			final int col = columnIndex - 1;
			int oid = this.metaData.getFields().get(col).getType().getOid();
			return this.readFloat(this_row[col], oid);
		}

		String str = this.getString(columnIndex);
		if (str == null || str.trim().equals("")) {
			return 0;
		}

		str = str.trim();
		try {
			return Double.parseDouble(str);
		} catch (NumberFormatException e) {
			throw new SQLException(e);
		}
	}

	@Override
	public BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
		this.checkCollumn(columnIndex);
		if (wasNull) {
			return null;
		}

		String str = this.getString(columnIndex);
		if (str == null || str.trim().isEmpty()) {
			return null;
		}

		BigDecimal dec = null;
		try {
			dec = new BigDecimal(str);
			if (scale > -1) {
				dec.setScale(scale);
			}
		} catch (NumberFormatException e) {
			throw new SQLException(e);
		}
		return dec;
	}

	@Override
	public byte[] getBytes(int columnIndex) throws SQLException {
		this.checkCollumn(columnIndex);
		if (wasNull) {
			return null;
		}

		// TODO Blob Clob实现
		return this_row[columnIndex - 1];
	}

	@Override
	public Date getDate(int columnIndex) throws SQLException {
		this.checkCollumn(columnIndex);
		if (wasNull) {
			return null;
		}

		String dateStr = this.getString(columnIndex);
		if (dateStr == null || dateStr.trim().isEmpty()) {
			return null;
		}

		java.util.Date date = null;
		try {
			date = DateUtils.parse(dateStr, DateUtils.YYYYMMDDHHMMSSSSS);
		} catch (ParseException e) {
			throw new SQLException(e);
		}
		return new Date(date.getTime());
	}

	@Override
	public Time getTime(int columnIndex) throws SQLException {
		this.checkCollumn(columnIndex);
		if (wasNull) {
			return null;
		}

		String dateStr = this.getString(columnIndex);
		if (dateStr == null || dateStr.trim().isEmpty()) {
			return null;
		}

		java.util.Date date = null;
		try {
			date = DateUtils.parse(dateStr, DateUtils.YYYYMMDDHHMMSSSSS);
		} catch (ParseException e) {
			throw new SQLException(e);
		}
		return new Time(date.getTime());
	}

	@Override
	public Timestamp getTimestamp(int columnIndex) throws SQLException {
		this.checkCollumn(columnIndex);
		if (wasNull) {
			return null;
		}

		Time time = this.getTime(columnIndex);
		return new Timestamp(time.getTime());
	}

	@Override
	public InputStream getAsciiStream(int columnIndex) throws SQLException {
		this.checkCollumn(columnIndex);
		if (wasNull) {
			return null;
		}

		try {
			return new ByteArrayInputStream(getString(columnIndex).getBytes("ASCII"));
		} catch (UnsupportedEncodingException e) {
			throw new SQLException(e);
		}
	}

	@Override
	public InputStream getUnicodeStream(int columnIndex) throws SQLException {
		this.checkCollumn(columnIndex);
		if (wasNull) {
			return null;
		}

		try {
			return new ByteArrayInputStream(getString(columnIndex).getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new SQLException(e);
		}
	}

	@Override
	public InputStream getBinaryStream(int columnIndex) throws SQLException {
		this.checkCollumn(columnIndex);
		if (wasNull) {
			return null;
		}

		byte b[] = getBytes(columnIndex);
		if (b != null) {
			return new ByteArrayInputStream(b);
		}

		return null;
	}

	@Override
	public String getString(String columnLabel) throws SQLException {
		int columnIndex = this.metaData.getColumnIndex(columnLabel);
		return this.getString(columnIndex);
	}

	@Override
	public boolean getBoolean(String columnLabel) throws SQLException {
		int columnIndex = this.metaData.getColumnIndex(columnLabel);
		return this.getBoolean(columnIndex);
	}

	@Override
	public byte getByte(String columnLabel) throws SQLException {
		int columnIndex = this.metaData.getColumnIndex(columnLabel);
		return this.getByte(columnIndex);
	}

	@Override
	public short getShort(String columnLabel) throws SQLException {
		int columnIndex = this.metaData.getColumnIndex(columnLabel);
		return this.getShort(columnIndex);
	}

	@Override
	public int getInt(String columnLabel) throws SQLException {
		int columnIndex = this.metaData.getColumnIndex(columnLabel);
		return this.getInt(columnIndex);
	}

	@Override
	public long getLong(String columnLabel) throws SQLException {
		int columnIndex = this.metaData.getColumnIndex(columnLabel);
		return this.getLong(columnIndex);
	}

	@Override
	public float getFloat(String columnLabel) throws SQLException {
		int columnIndex = this.metaData.getColumnIndex(columnLabel);
		return this.getFloat(columnIndex);
	}

	@Override
	public double getDouble(String columnLabel) throws SQLException {
		int columnIndex = this.metaData.getColumnIndex(columnLabel);
		return this.getDouble(columnIndex);
	}

	@Override
	public BigDecimal getBigDecimal(String columnLabel, int scale) throws SQLException {
		int columnIndex = this.metaData.getColumnIndex(columnLabel);
		return this.getBigDecimal(columnIndex, scale);
	}

	@Override
	public byte[] getBytes(String columnLabel) throws SQLException {
		int columnIndex = this.metaData.getColumnIndex(columnLabel);
		return this.getBytes(columnIndex);
	}

	@Override
	public Date getDate(String columnLabel) throws SQLException {
		int columnIndex = this.metaData.getColumnIndex(columnLabel);
		return this.getDate(columnIndex);
	}

	@Override
	public Time getTime(String columnLabel) throws SQLException {
		int columnIndex = this.metaData.getColumnIndex(columnLabel);
		return this.getTime(columnIndex);
	}

	@Override
	public Timestamp getTimestamp(String columnLabel) throws SQLException {
		int columnIndex = this.metaData.getColumnIndex(columnLabel);
		return this.getTimestamp(columnIndex);
	}

	@Override
	public InputStream getAsciiStream(String columnLabel) throws SQLException {
		int columnIndex = this.metaData.getColumnIndex(columnLabel);
		return this.getAsciiStream(columnIndex);
	}

	@Override
	public InputStream getUnicodeStream(String columnLabel) throws SQLException {
		int columnIndex = this.metaData.getColumnIndex(columnLabel);
		return this.getUnicodeStream(columnIndex);
	}

	@Override
	public InputStream getBinaryStream(String columnLabel) throws SQLException {
		int columnIndex = this.metaData.getColumnIndex(columnLabel);
		return this.getBinaryStream(columnIndex);
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		return null;
	}

	@Override
	public void clearWarnings() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getCursorName() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSetMetaData getMetaData() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getObject(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getObject(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findColumn(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Reader getCharacterStream(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reader getCharacterStream(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getBigDecimal(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isBeforeFirst() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAfterLast() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFirst() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLast() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void beforeFirst() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterLast() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean first() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean last() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getRow() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean absolute(int row) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean relative(int rows) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean previous() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFetchDirection(int direction) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getFetchDirection() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setFetchSize(int rows) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getFetchSize() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getType() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getConcurrency() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean rowUpdated() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rowInserted() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rowDeleted() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateNull(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBoolean(int columnIndex, boolean x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateByte(int columnIndex, byte x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateShort(int columnIndex, short x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateInt(int columnIndex, int x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateLong(int columnIndex, long x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateFloat(int columnIndex, float x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateDouble(int columnIndex, double x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBigDecimal(int columnIndex, BigDecimal x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateString(int columnIndex, String x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBytes(int columnIndex, byte[] x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateDate(int columnIndex, Date x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTime(int columnIndex, Time x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTimestamp(int columnIndex, Timestamp x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAsciiStream(int columnIndex, InputStream x, int length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBinaryStream(int columnIndex, InputStream x, int length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCharacterStream(int columnIndex, Reader x, int length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateObject(int columnIndex, Object x, int scaleOrLength) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateObject(int columnIndex, Object x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateNull(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBoolean(String columnLabel, boolean x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateByte(String columnLabel, byte x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateShort(String columnLabel, short x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateInt(String columnLabel, int x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateLong(String columnLabel, long x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateFloat(String columnLabel, float x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateDouble(String columnLabel, double x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBigDecimal(String columnLabel, BigDecimal x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateString(String columnLabel, String x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBytes(String columnLabel, byte[] x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateDate(String columnLabel, Date x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTime(String columnLabel, Time x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTimestamp(String columnLabel, Timestamp x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAsciiStream(String columnLabel, InputStream x, int length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBinaryStream(String columnLabel, InputStream x, int length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCharacterStream(String columnLabel, Reader reader, int length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateObject(String columnLabel, Object x, int scaleOrLength) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateObject(String columnLabel, Object x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertRow() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateRow() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteRow() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void refreshRow() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelRowUpdates() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveToInsertRow() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveToCurrentRow() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Statement getStatement() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getObject(int columnIndex, Map<String, Class<?>> map) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ref getRef(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blob getBlob(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clob getClob(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Array getArray(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getObject(String columnLabel, Map<String, Class<?>> map) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ref getRef(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blob getBlob(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clob getClob(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Array getArray(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getDate(int columnIndex, Calendar cal) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getDate(String columnLabel, Calendar cal) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Time getTime(int columnIndex, Calendar cal) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Time getTime(String columnLabel, Calendar cal) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Timestamp getTimestamp(String columnLabel, Calendar cal) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URL getURL(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URL getURL(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRef(int columnIndex, Ref x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateRef(String columnLabel, Ref x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBlob(int columnIndex, Blob x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBlob(String columnLabel, Blob x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateClob(int columnIndex, Clob x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateClob(String columnLabel, Clob x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateArray(int columnIndex, Array x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateArray(String columnLabel, Array x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public RowId getRowId(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RowId getRowId(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRowId(int columnIndex, RowId x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateRowId(String columnLabel, RowId x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getHoldability() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isClosed() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateNString(int columnIndex, String nString) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateNString(String columnLabel, String nString) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateNClob(int columnIndex, NClob nClob) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateNClob(String columnLabel, NClob nClob) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public NClob getNClob(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NClob getNClob(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQLXML getSQLXML(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQLXML getSQLXML(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSQLXML(int columnIndex, SQLXML xmlObject) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateSQLXML(String columnLabel, SQLXML xmlObject) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getNString(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNString(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reader getNCharacterStream(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reader getNCharacterStream(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateNCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateNCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAsciiStream(int columnIndex, InputStream x, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBinaryStream(int columnIndex, InputStream x, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAsciiStream(String columnLabel, InputStream x, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBinaryStream(String columnLabel, InputStream x, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBlob(int columnIndex, InputStream inputStream, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBlob(String columnLabel, InputStream inputStream, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateClob(int columnIndex, Reader reader, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateClob(String columnLabel, Reader reader, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateNClob(int columnIndex, Reader reader, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateNClob(String columnLabel, Reader reader, long length) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateNCharacterStream(int columnIndex, Reader x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateNCharacterStream(String columnLabel, Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAsciiStream(int columnIndex, InputStream x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBinaryStream(int columnIndex, InputStream x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCharacterStream(int columnIndex, Reader x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAsciiStream(String columnLabel, InputStream x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBinaryStream(String columnLabel, InputStream x) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCharacterStream(String columnLabel, Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBlob(int columnIndex, InputStream inputStream) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBlob(String columnLabel, InputStream inputStream) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateClob(int columnIndex, Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateClob(String columnLabel, Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateNClob(int columnIndex, Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateNClob(String columnLabel, Reader reader) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> T getObject(int columnIndex, Class<T> type) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getObject(String columnLabel, Class<T> type) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * 检查列
	 * 
	 * @param column
	 * 
	 * @throws SQLException
	 */
	protected void checkCollumn(int column) throws SQLException {
		if (this_row == null || column < -1 || column > this_row.length) {
			throw new SQLException("column[" + column + "] out of index");
		}

		this.wasNull = (this_row[column] == null);
	}

	/*
	 * 判断列内容是否为二进制类型
	 * 
	 * @param column
	 * 
	 * @return
	 */
	protected boolean isCollumnBin(int column) {
		Field field = this.metaData.getFields().get(column);
		return getSQLType(column) != Types.VARCHAR && field.getFormat() == Field.FORMAT_BIN;
	}

	/*
	 * 获取SQLType
	 * 
	 * @param column
	 * 
	 * @return
	 */
	protected int getSQLType(int column) {
		Field field = this.metaData.getFields().get(column);
		return field.getType().getSqlType();
	}

	/*
	 * 参照postgresql
	 * 
	 * @param columnIndex
	 * 
	 * @param field
	 * 
	 * @return
	 * 
	 * @throws SQLException
	 */
	protected Object getObject(int columnIndex, Field field) throws SQLException {
		switch (getSQLType(columnIndex)) {
		case Types.BIT:
			return getBoolean(columnIndex) ? Boolean.TRUE : Boolean.FALSE;
		case Types.TINYINT:
		case Types.SMALLINT:
		case Types.INTEGER:
			return new Integer(getInt(columnIndex));
		case Types.BIGINT:
			return new Long(getLong(columnIndex));
		case Types.NUMERIC:
		case Types.DECIMAL:
			return getBigDecimal(columnIndex, -1);
		case Types.REAL:
			return new Float(getFloat(columnIndex));
		case Types.FLOAT:
		case Types.DOUBLE:
			return new Double(getDouble(columnIndex));
		case Types.CHAR:
		case Types.VARCHAR:
		case Types.LONGVARCHAR:
			return getString(columnIndex);
		case Types.DATE:
			return getDate(columnIndex);
		case Types.TIME:
			return getTime(columnIndex);
		case Types.TIMESTAMP:
			return getTimestamp(columnIndex, null);
		case Types.BINARY:
		case Types.VARBINARY:
		case Types.LONGVARBINARY:
			return getBytes(columnIndex);
		case Types.ARRAY:
			return getArray(columnIndex);
		case Types.CLOB:
			return getClob(columnIndex);
		case Types.BLOB:
			return getBlob(columnIndex);
		}

		return null;
	}

	/*
	 * 读取浮点数据类型
	 * 
	 * @param data
	 * 
	 * @param oid
	 * 
	 * @return
	 */
	private double readFloat(byte[] data, int oid) {
		switch (oid) {
		case Oid.INT2:
			return NumberUtils.readInt2(data);

		case Oid.INT4:
			return NumberUtils.readInt4(data);

		case Oid.INT8:
			return NumberUtils.readInt8(data);

		case Oid.FLOAT4:
			int intBit = NumberUtils.readInt4(data);
			return Float.intBitsToFloat(intBit);

		case Oid.FLOAT8:
			long longBit = NumberUtils.readInt8(data);
			return Double.longBitsToDouble(longBit);
		}

		return 0;
	}

	/**
	 * <p>
	 * 接受数据线程
	 * 
	 * @author river
	 * @since Dec 28, 2013
	 */
	private class ReceiveThread extends Thread {
		private boolean alive;

		@Override
		public void run() {
			while (alive) {
				try {
					Message msg = protoStream.receive();
					this.handleMsg(msg);
				} catch (Throwable e) {
					// error logic
				}
			}
		}

		/*
		 * 处理收到的协议消息
		 * 
		 * @param msg
		 */
		private void handleMsg(Message msg) {
			Message.Type type = msg.getType();
			switch (type) {
			case ROW_DESC:
				List<Field> fields = ProtoUtils.decodeRowDescMsg(msg);
				this.handleRowDesc(fields);
				return;
			case DATA_TRANSFER:
				this.handleRowData(msg);
				return;
			}
		}

		/*
		 * 处理记录描述消息
		 * 
		 * @param fields
		 */
		private void handleRowDesc(List<Field> fields) {
			metaData.setFields(fields);
		}

		/*
		 * 处理行数据信息
		 * 
		 * @param msg
		 */
		private void handleRowData(Message msg) {
			synchronized (lock) {
				byte[][] row = ProtoUtils.decodeRowData(msg);
				rows.add(row);
				lock.notifyAll();
			}
		}

	}

	public static enum Status {
		NEW, BUFFERED, CLOSED;
	}

}
