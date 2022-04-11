package com.example.AppPfe.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

    @Entity
    public class DirectionRegionale {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String codedirection;
        private String libelleDirection;

    private String typedirection;
    private String lieu_d_archivage_1_ere_age;
    private String lieu_d_archivage_2_eme_age;
}