package org.river.sealand.meta.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.river.sealand.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * <p>
 * 接收临时文件
 * 
 * @author River
 * @date 2013-7-18
 */
public class TempFileIoHandler extends IoHandlerAdapter
{
    private static final Logger log = LoggerFactory.getLogger(TempFileIoHandler.class);
    private static final String TEMP_FILE_SUFFIX=".zip";
    private static final String TEMP_FILE_KEY="tmpfile";
    private static Integer cycle=0;
    
    private String tmpDir;
    
    

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        session.setAttribute(TEMP_FILE_KEY, new FileOutputStream(this.getFile()));
        super.sessionCreated(session);
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        final int BUFFERED_SIZE = 1024;
        IoBuffer buf = (IoBuffer) message;
        byte[] buffer = new byte[BUFFERED_SIZE];
        OutputStream os = (OutputStream)session.getAttribute(TEMP_FILE_KEY);

        // 读取文件，并写入会话缓存
        while (buf.hasRemaining()) {
            int remain = buf.remaining();
            if (remain >= BUFFERED_SIZE) {
                buf.get(buffer, 0, BUFFERED_SIZE);
                os.write(buffer, 0, BUFFERED_SIZE);
            } else if (remain > 0) {
                buf.get(buffer, 0, remain);
                os.write(buffer, 0, remain);
            }
        }  
        os.flush();     
        
    }
    
    
    
    @Override
    public void sessionClosed(IoSession session) throws Exception {
        OutputStream os = (OutputStream)session.getAttribute(TEMP_FILE_KEY);
        os.close();
        super.sessionClosed(session);
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        log.error(cause.getMessage(),cause);
        super.exceptionCaught(session, cause);
    }

    /**
     * <P>
     * 获取临时文件
     * @return
     */
    private File getFile(){
        String filePath="";
        synchronized(cycle){
            cycle++;
            filePath=tmpDir+"/"+DateUtils.format(new Date(), DateUtils.YYYYMMDDHHMMSS)+cycle.toString()+TEMP_FILE_SUFFIX;
        }
        
        return new File(filePath);
    }
    
    
    public String getTmpDir() {
        return tmpDir;
    }

    public void setTmpDir(String tmpDir) {
        this.tmpDir = tmpDir;
    }
}
