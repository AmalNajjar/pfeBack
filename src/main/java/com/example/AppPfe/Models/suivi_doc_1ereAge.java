package com.example.AppPfe.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class suivi_doc_1ereAge extends suivi_document {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name ="libelleDirection",referencedColumnName="libelleDirection")
    private DirectionRegionale libelleDirection;
    //  @JoinColumn(name = "libelleDirection",referencedColumnName = " libelleDirection")}
}
