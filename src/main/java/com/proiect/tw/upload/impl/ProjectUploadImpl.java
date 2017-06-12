package com.proiect.tw.upload.impl;

import com.proiect.tw.service.ProjectService;
import com.proiect.tw.service.UploadService;
import com.proiect.tw.upload.ProjectUpload;
import com.proiect.tw.vo.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by JACK on 6/12/2017.
 */
@Component
public class ProjectUploadImpl implements ProjectUpload {

    @Autowired
    private UploadService uploadService;

    @Autowired
    private ProjectService projectService;

    @Override
    public boolean uploadProject(int id_proj, MultipartFile uploadedFile) {

        ProjectVO projectVO = projectService.getProject(id_proj);

        if (projectVO != null){
            String newFileName = "Project_" + projectVO.getTitle()+ "_" + id_proj + ".zip";

            projectVO.setFile(newFileName);
            projectService.updateProject(id_proj, projectVO);

            uploadService.uploadFile(newFileName, uploadedFile);
        }

        return true;
    }

}
