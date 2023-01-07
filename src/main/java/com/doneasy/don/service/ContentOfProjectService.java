package com.doneasy.don.service;

import com.doneasy.don.domain.project.ContentOfProject;
import com.doneasy.don.dto.ContentOfProjectShowDto;
import com.doneasy.don.repository.project.ContentOfProjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContentOfProjectService {
    private final ContentOfProjectRepository contentOfProjectRepository;
    @Value("${file.dir}") private String path;

    public List<byte[]> getByteArray(List<String> imageList) throws IOException {
        byte[] array = new byte[imageList.size()];
        List<byte[]> list = new ArrayList<byte[]>();

        for (String s : imageList) {
            File file = new File(getFullPath(s));
            array =  Files.readAllBytes(file.toPath());
            list.add(array);

        }

        return list;
    }
    private String getFullPath(String image_name) {
        return path + image_name;
    }



}
