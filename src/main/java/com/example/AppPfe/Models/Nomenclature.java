package com.example.AppPfe.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nomenclature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int code_Nomenclature;
    private String designation_Nomenclature;
    private String dureeConservation_1ereAge;
    private String dureeConservation_2emeAge;
    private String valeurHistorique_3emeAge;
}
