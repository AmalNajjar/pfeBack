package com.example.AppPfe.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table
public class structureCentrale implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String libelle;

    @ManyToOne
    @JoinColumn(name ="lieu_archivage1ereAge",referencedColumnName ="Lieu")
    private lieuArchive lieu_archivage1ereAge;

    @ManyToOne
    @JoinColumn(name ="lieu_archivage2emeAge",referencedColumnName ="Lieu")
    private lieuArchive lieu_archivage2emeAge;

}
