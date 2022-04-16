package com.example.AppPfe.controllers;

import com.example.AppPfe.Models.compteUtilisateur;
import com.example.AppPfe.Models.lieuArchive;
import com.example.AppPfe.Models.structureCentrale;
import com.example.AppPfe.Models.suivi_doc_1ereAge;
import com.example.AppPfe.exception.EmailException;
import com.example.AppPfe.exception.ResourceNotFoundException;
import com.example.AppPfe.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

  @Autowired
  compteUtilisateurRepository compteRepository;
  @Autowired
  structureRepository structureRepository;
  @Autowired
  lieuArchiveRepo lieuArchiveRepository;
  @Autowired
  nomenclatureRepo nomenclatureRepositories ;
  @Autowired
  suiviDoc1erAgeRepo suiviDoc1erAgeRepository;

  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }

  @GetMapping("/auth")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  public String userAccess() {
    return "User Content.";
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() {

    return "Admin Board.";
  }

  @GetMapping("/lieu")
  List<lieuArchive> getAll(){
    return lieuArchiveRepository.findAll();
  }

  @GetMapping("/lieu/{id}")
  Optional<lieuArchive> getById(@PathVariable("id") Long id){
    System.out.println(id);
    return lieuArchiveRepository.findById(id);
  }


  @PostMapping("/Compte")
  public void register(@RequestBody compteUtilisateur compte) throws Exception {
    compteUtilisateur user=compteRepository.findByEmail(compte.getEmail());
    if(user != null){
      throw new EmailException("string email");
    }
    compteRepository.save(compte);
  }

  @GetMapping("/Comptes")
  public List<compteUtilisateur> getAllComptes() {
    return  compteRepository.findAll();
  }


  @GetMapping("/Comptes/{id}")
  public ResponseEntity<compteUtilisateur> getCompteById(@PathVariable(value = "id") Integer id)
          throws ResourceNotFoundException {
    compteUtilisateur compte = compteRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Compte not found"));
    return ResponseEntity.ok().body(compte);
  }


  @PutMapping("/Comptes/{id}")
  public ResponseEntity<compteUtilisateur>updateCompte(@PathVariable(value = "id") Integer id,
                                                            @RequestBody compteUtilisateur compteDetails)
          throws ResourceNotFoundException {
    compteUtilisateur compte= compteRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("compte not found"));

    compte.setNom(compteDetails.getNom());
    compte.setPrenom(compteDetails.getPrenom());
    compte.setDirection(compteDetails.getDirection());
    compte.setEmail(compteDetails.getEmail());
    compte.setPassword(compteDetails.getPassword());
    final compteUtilisateur updateCompte  = compteRepository.save(compte);
    return ResponseEntity.ok(compte );
  }

  @DeleteMapping("/Comptes/{id}")
  public Map<String, Boolean> deleteDirection(@PathVariable(value = "id") Integer id)
          throws ResourceNotFoundException {
    compteUtilisateur compte = compteRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Compte not found"));
    compteRepository.delete(compte);
    Map<String, Boolean> response = new HashMap<>();
    response.put("delete", Boolean.TRUE);
    return response;
  }

  @PostMapping("/Structure")
  public structureCentrale registerr(@RequestBody structureCentrale structure) {
    System.out.println(structure);
    return structureRepository.save(structure);
  }


  @GetMapping("/Structures")
  public List<structureCentrale> getAllStructures() {

    return  structureRepository.findAll();
  }

  @GetMapping("/Structures/{id}")
  public ResponseEntity<structureCentrale> getStructureById(@PathVariable(value = "id") Long id)
          throws ResourceNotFoundException {
    structureCentrale structure= structureRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Structure not found"));
    return ResponseEntity.ok().body(structure);
  }


  @PutMapping("/Structures/{id}")
  public ResponseEntity<structureCentrale>updateStructure(@PathVariable(value = "id") Long id,
                                                       @RequestBody structureCentrale structureDetails)
          throws ResourceNotFoundException {
    structureCentrale structure= structureRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Structure not found"));

    structure.setCode(structureDetails.getCode());
    structure.setLibelle(structureDetails.getLibelle());
    structure.setLieu_archivage1ereAge(structureDetails.getLieu_archivage1ereAge());
    structure.setLieu_archivage2emeAge(structureDetails.getLieu_archivage2emeAge());
    final structureCentrale updateStructure  = structureRepository.save(structure);
    return ResponseEntity.ok(structure );
  }

  @DeleteMapping("/Structures/{id}")
  public Map<String, Boolean> deleteStructure(@PathVariable(value = "id") Long id)
          throws ResourceNotFoundException {
    structureCentrale structure= structureRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Structure not found"));
    structureRepository.delete(structure);
    Map<String, Boolean> response = new HashMap<>();
    response.put("delete", Boolean.TRUE);
    return response;
  }

  @GetMapping("/Comptes/findbyEmail/{email}")
  public compteUtilisateur trouverParEmail(@PathVariable String email){
    return compteRepository.findByEmail(email);
  }

  //traitement 1 ere age

  @PostMapping("/SuiviDocument")
  public void saveDocument(@RequestBody suivi_doc_1ereAge suivi_doc_1ereAge) {
    suiviDoc1erAgeRepository.save(suivi_doc_1ereAge);}

  @GetMapping("/SuiviDocuments")
  public List<suivi_doc_1ereAge> getAllDocuments() {
    return  suiviDoc1erAgeRepository.findAll();
  }
  @GetMapping("/SuiviDocuments/{id}")
  public ResponseEntity<suivi_doc_1ereAge> getDocumentsById(@PathVariable(value = "id") Long id)
          throws ResourceNotFoundException {
    suivi_doc_1ereAge suivi_doc_1ereAge = suiviDoc1erAgeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Document not found"));
    return ResponseEntity.ok().body(suivi_doc_1ereAge);
  }
}