package org.cnam.sample.model;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "libelle_frais")
public class LibelleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libelle")
    private Long id_libelle;

    @Column(name = "libelle_frais")
    private String libelle_frais;

    @Column(name = "montant_fixe")
    private double montant_fixe;

    @Column(name = "montant_pourcentage")
    private double montant_pourcentage;

    public LibelleModel()
    {

    }


}
