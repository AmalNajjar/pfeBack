package com.example.AppPfe.repository;

import com.example.AppPfe.Models.compteUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface compteUtilisateurRepository extends JpaRepository<compteUtilisateur,Integer> {
compteUtilisateur findByEmail(String email);
}
