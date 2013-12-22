package org.river.sealand.postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import junit.framework.TestCase;

public class PostgresTestCase extends TestCase {

	public void testQuery(){
		final String sql="select * from T_C";
		String url = "jdbc:postgresql://127.0.0.1:5432/sealand";
		String usr = "admin";
		String psd = "admin";
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, usr, psd);
			Statement st = conn.createStatement();
			st.execute("insert into T_C values('11','22')");
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.print(rs.getString(1));
				System.out.print("  ");
				System.out.println(rs.getString(2));
			}
			rs.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
