package com.example.AppPfe.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class typeDirection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String codeType_dir;
    private String libelle_type_dir;
    @OneToMany(mappedBy = "typeDirection")
    private List<DirectionRegionale> direction_regionaleList=new ArrayList<>();


    //@JsonIgnore
    //private Direction_Regionale directionRegionale;
    //@OneToMany
    //@JoinColumn(name = "libelleDirection",referencedColumnName = "libelleDirection")
    //List<Direction_Regionale> typedirection= new ArrayList<>();
}
