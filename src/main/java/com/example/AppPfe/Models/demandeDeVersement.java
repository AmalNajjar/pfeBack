package com.example.AppPfe.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class demandeDeVersement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int num_dde;
    private Date date_dde;
    private String objet;
    private int nbrCarton ;
    private String etat;
}
