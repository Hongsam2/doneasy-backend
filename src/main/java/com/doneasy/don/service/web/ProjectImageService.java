package com.doneasy.don.service.web;

import com.doneasy.don.domain.project.ProjectBoard;
import com.doneasy.don.dto.project.ProjectBoardShowdto;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;

public class ProjectImageService {

    @Value("${stored.dir}") private String path;

    public byte[] getByteArray(ProjectBoardShowdto projectBoardShowdto){
        File file new File(getFullPath())
    }

    public String getFullPath(String storedName){
        return path + storedName;
    }


}
