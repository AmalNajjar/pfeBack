package com.example.AppPfe.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Nomenclature implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int code_Nomenclature;
    private String designation_Nomenclature;
    private String dureeConservation_1ereAge;
    private String dureeConservation_2emeAge;
    private String valeurHistorique_3emeAge;
    @ManyToOne(cascade = CascadeType.ALL)
    private suivi_document suivi_documents;
}
