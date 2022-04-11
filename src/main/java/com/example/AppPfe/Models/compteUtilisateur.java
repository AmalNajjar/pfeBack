package com.example.AppPfe.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Entity @Data @NoArgsConstructor @AllArgsConstructor @ToString
public class compteUtilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String  password;
    @Column(unique =true)
    private String email;
    private String direction;
}
