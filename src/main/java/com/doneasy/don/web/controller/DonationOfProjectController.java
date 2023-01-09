package com.doneasy.don.web.controller;

import com.doneasy.don.dto.project.DonationOfProjectDto;
import com.doneasy.don.repository.project.DonationOfProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/donation-of-project")
@RequiredArgsConstructor
public class DonationOfProjectController {

    private final DonationOfProjectRepository donationOfProjectRepository;


    @PostMapping("/get-donation")
    public ResponseEntity<List<DonationOfProjectDto>> getDonation() {
        List<DonationOfProjectDto> list = donationOfProjectRepository.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
