package com.proiect.tw.upload;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by JACK on 6/12/2017.
 */
public interface ProjectUpload {

    boolean uploadProject(int id_proj, MultipartFile uploadingFile);
}
