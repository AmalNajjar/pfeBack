package com.example.AppPfe.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class suivi_doc_3emeAge extends suivi_document{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
