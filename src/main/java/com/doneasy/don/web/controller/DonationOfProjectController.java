package com.doneasy.don.web.controller;

import com.doneasy.don.domain.project.DonationOfProject;
import com.doneasy.don.dto.DonationOfProjectShowDto;
import com.doneasy.don.repository.project.DonationOfProjectRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/donation-of-project")
public class DonationOfProjectController {

    private final DonationOfProjectRepository donationOfProjectRepository;
    @PostMapping("/get-donation")
    public ResponseEntity<List<DonationOfProjectShowDto>> getDonator(HttpServletRequest req, HttpServletResponse res, int id) {

        List<DonationOfProjectShowDto> donationOfProjectList = donationOfProjectRepository.findAllById(id);

        return new ResponseEntity<>(donationOfProjectList, HttpStatus.OK);
    }
    @PostMapping("/pay")
    public ResponseEntity pay(String adminKey) {



        return new ResponseEntity(HttpStatus.OK);
    }
}
