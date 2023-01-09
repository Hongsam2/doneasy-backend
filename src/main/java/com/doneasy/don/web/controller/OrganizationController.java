package com.doneasy.don.web.controller;

import com.doneasy.don.dto.organization.OrganizationDetailDto;
import com.doneasy.don.service.organization.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/organization")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @GetMapping(value = "/detail")
        public ResponseEntity<OrganizationDetailDto> getDetail() throws IOException {
            OrganizationDetailDto organizationDetailDto = organizationService.getOrganizationDetail("zxc123");
            return new ResponseEntity<>(organizationDetailDto, HttpStatus.OK);
    }

}
