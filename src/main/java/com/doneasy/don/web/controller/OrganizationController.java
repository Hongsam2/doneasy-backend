package com.doneasy.don.web.controller;


import com.doneasy.don.domain.user.Organization;
import com.doneasy.don.dto.user.OrganizationSavedto;
import com.doneasy.don.repository.user.OrganizationRepository;
import com.doneasy.don.service.user.OrganizationImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/organization")
public class OrganizationController {

    private final OrganizationRepository organizationRepository;

    private final OrganizationImageService organizationImageService;

    @PostMapping("/save")
    public ResponseEntity saveOrganization(OrganizationSavedto organizationSavedto
            ,@RequestPart(value = "image_name") List<MultipartFile> multipartFiles) throws IOException {
        //String imageName = multipartFiles.get(0).getOriginalFilename();
        String save = organizationImageService.save(multipartFiles);
        //System.out.println(imageName);
        Organization organization = Organization.getOrganization(organizationSavedto, save);
        System.out.println(organizationSavedto);
        organizationRepository.saveOrganization(organization);

        return new ResponseEntity(HttpStatus.OK);
    }
}
