package com.proiect.tw.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by JACK on 6/12/2017.
 */
public interface UploadService {

    String getFilePath(long memberId, String section);
    boolean uploadFile(String newFileName, MultipartFile uploadFile);
    void deleteFile(String filePath, String newFileName);
}
