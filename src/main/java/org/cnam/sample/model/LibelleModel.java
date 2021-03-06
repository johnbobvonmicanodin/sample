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

    public LibelleModel(long id_libelle, String libelle_frais, double montant_fixe, double montant_pourcentage)
    {
        this.id_libelle = id_libelle;
        this.libelle_frais = libelle_frais;
        this.montant_fixe = montant_fixe;
        this.montant_pourcentage = montant_pourcentage;

    }

    public Long getId_libelle() {
        return id_libelle;
    }

    public String getLibelle_frais() {
        return libelle_frais;
    }

    public double getMontant_fixe() {
        return montant_fixe;
    }

    public double getMontant_pourcentage() {
        return montant_pourcentage;
    }
}
