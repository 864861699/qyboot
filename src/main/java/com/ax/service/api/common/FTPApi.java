package com.ax.service.api.common;

import com.ax.service.config.component.FileUpload;
import com.ax.service.utils.RD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RequestMapping("/ftp/api")
@RestController
public class FTPApi {
    private FileUpload fileUpload;

    @Autowired
    public FTPApi(FileUpload fileUpload) {
        this.fileUpload = fileUpload;
    }

    @PostMapping("/batch2")
    public RD batchUpload11(@RequestParam("file") MultipartFile file,HttpServletRequest request) {
        try {
            String file_name = fileUpload.upload(file);
            return RD.success(file_name);
        } catch (IOException e) {
            e.printStackTrace();
            return RD.error("Failed");
        }
    }
}
