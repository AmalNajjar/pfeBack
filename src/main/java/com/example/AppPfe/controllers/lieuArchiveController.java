package com.example.AppPfe.controllers;

import com.example.AppPfe.Models.lieuArchive;
import com.example.AppPfe.repository.lieuArchiveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/example")
public class lieuArchiveController {

}
