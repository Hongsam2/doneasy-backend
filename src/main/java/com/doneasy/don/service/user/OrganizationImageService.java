package com.doneasy.don.service.user;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrganizationImageService {

        @Value("${file.dir}") private String path;

    public String save(List<MultipartFile> multipartFiles) throws IOException {
        MultipartFile imageFile = multipartFiles.get(0);
        String storedName = UUID.randomUUID().toString() + imageFile.getOriginalFilename();
        imageFile.transferTo(new File(path+storedName));
        return storedName;
    }


}
