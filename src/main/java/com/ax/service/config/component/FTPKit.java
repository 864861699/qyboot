package com.ax.service.config.component;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.regex.Matcher;

/**
 * FTP上传工具
 *
 * @author 喵♂呜
 * @since 2016年4月26日 上午8:57:35
 */
public class FTPKit {
    private FTPClient ftp;

    private static Logger log = Logger.getLogger(File.class.getCanonicalName());

    @Value("${ftp.addr}")
    private static String addr;

    @Value("${ftp.port}")
    private static Integer port;

    @Value("${ftp.user}")
    private static String user;

    @Value("${ftp.pass}")
    private static String pass;

//    public static void main(final String[] args) throws Exception {
//        final FTPKit fk = new FTPKit();
//        fk.connect(addr, port, user, pass);
//        final File file = new File("E:\\JTB\\JavaWebSite\\webapps\\ECP", "upload\\img\\PIX2LIm.png");
//        fk.uploadFile(file);
//    }

    public static void init(FtpSetting ftpSetting) {
        addr = ftpSetting.getAddr();
        port = Integer.valueOf(ftpSetting.getPort());
        user = ftpSetting.getUser();
        pass = ftpSetting.getPass();
    }

    /**
     * 上传文件或文件夹
     *
     * @param file
     *         需要上传的文件或文件夹
     * @return 是否成功
     */
    public static boolean upload(final File file) {
        final FTPKit fk = new FTPKit();
        try {
            fk.connect();
            fk.uploadFile(file);
            fk.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * 上传文件或文件夹
     *
     * @param file
     *         需要上传的文件或文件夹
     * @return 是否成功
     */
    public static boolean upload(final String path, final File file) {
        final FTPKit fk = new FTPKit();
        final long t = System.currentTimeMillis();
        try {
            if (!fk.connect()) {
                log.warning("FTP连接失败!");
                return false;
            }
            final boolean result = fk.uploadFile(path, file);
            log.info("上传文件 " + file.toPath() + " 到 " + path + " 结果: " + result + " 耗时: " + (System.currentTimeMillis() - t));
            fk.close();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * 关闭链接
     *
     * @return 状态值
     * @throws IOException
     *         IO异常
     */
    public int close() throws IOException {
        return ftp.quit();
    }

    /**
     * 通过配置文件连接FTP服务器
     *
     * @return 状态值
     * @throws IOException
     *         IO异常
     */
    public boolean connect() throws Exception {
        return connect(addr, port, user, pass);
    }

    /**
     * 连接到FTP服务器
     *
     * @param addr
     *         地址
     * @param port
     *         端口号
     * @param username
     *         用户名
     * @param password
     *         密码
     * @return 状态值
     * @throws IOException
     *         IO异常
     */
    private boolean connect(final String addr, final int port, final String username, final String password) throws Exception {
        ftp = new FTPClient();
        int reply;
        ftp.connect(addr, port);
        ftp.login(username, password);
        ftp.setConnectTimeout(5000);
        ftp.setDataTimeout(5000);
        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
        ftp.enterLocalPassiveMode();/*被动模式*/
        reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            return false;
        }
        ftp.changeWorkingDirectory("/");
        return true;
    }

    /**
     * 上传文件
     *
     * @param file
     *         上传的文件或文件夹
     * @throws IOException
     *         IO异常
     */
    public boolean uploadFile(final File file) throws Exception {
        boolean result;
        final FileInputStream input = new FileInputStream(file);
        result = ftp.storeFile(file.getName(), input);
        input.close();
        return result;
    }

    /**
     * 上传文件
     *
     * @param filename
     *         上传的文件或文件夹
     * @throws IOException
     *         IO异常
     */
    public boolean uploadFile(final String filename) throws Exception {
        return uploadFile(new File(filename));
    }

    /**
     * 切换并创建目录
     *
     * @param path
     *         路径
     * @throws IOException
     *         IO异常
     */
    private void changeAndMakeDir(final String path) throws IOException {
        final String[] dirs = path.split(Matcher.quoteReplacement("/"));
        ftp.changeWorkingDirectory("/");
        for (final String dir : dirs) {
            ftp.makeDirectory(dir);
            ftp.changeWorkingDirectory(dir);
        }
    }

    /**
     * 上传文件到指定FTP目录
     *
     * @param path
     *         FTP目录
     * @param file
     *         文件
     * @return 是否成功
     * @throws IOException
     *         IO异常
     */
    private boolean uploadFile(final String path, final File file) throws Exception {
        changeAndMakeDir(path);
        return uploadFile(file);
    }
}
