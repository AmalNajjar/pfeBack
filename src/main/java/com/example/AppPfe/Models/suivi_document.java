package com.example.AppPfe.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class suivi_document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int num_doc;
    private String chapitre_comptable ;
    private int nbr_pages;
    private Date date_creation;
    private Date date_entree;
    private int nbr_doc ;
    private String limite_conservation;
}
