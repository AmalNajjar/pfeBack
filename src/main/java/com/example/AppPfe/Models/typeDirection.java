package com.example.AppPfe.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class typeDirection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code_TypeDir;

    @ManyToOne
    @JoinColumn(name ="libelle_TypeDir")
    @JsonIgnore
    private suivi_doc_1ereAge libelle_TypeDir;
}
