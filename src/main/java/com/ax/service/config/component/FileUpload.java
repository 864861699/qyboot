package com.ax.service.config.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

/**
 * FTP上传工具
 */
@Component
public class FileUpload {
    private FtpSetting ftpSetting;

    @Autowired
    public FileUpload(FtpSetting ftpSetting) {
        this.ftpSetting = ftpSetting;
        FTPKit.init(ftpSetting);
    }

    //文件上传
    public String upload(MultipartFile file) throws IOException {
        Calendar now  = Calendar.getInstance();
        return upload(file, "/qy/" + now.get(Calendar.YEAR) + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.DATE));
    }

    //文件上传
    public String upload(MultipartFile file, String target) throws IOException {
        String fileName = file.getOriginalFilename();

        /*中文上传不正常，这里直接修改零时文件名称*/
        //获得后缀
        String fileExt = fileName.substring(fileName.lastIndexOf("."));

        File tempFile = null;
        tempFile=File.createTempFile("qy2", fileExt);

        //保存临时文件到服务器
        file.transferTo(tempFile);
        //拼接文件名称 目录 + 文件 MD5 + 文件大小 + 文件后缀
        //String filePath = target + "/" + md5 + file.getSize() + fileExt;
        String filePath = target;
        //上传到FTP
        FTPKit.upload(filePath, tempFile);
        // 删除文件 tempFile.deleteOnExit();
        tempFile.delete();
        //返回上传成功后的文件的相对路径
        return filePath + "/" + tempFile.getName();
    }

    private File getFile(String fileName) {
        return new File(System.getProperty("java.io.tmpdir"), fileName);
    }
}