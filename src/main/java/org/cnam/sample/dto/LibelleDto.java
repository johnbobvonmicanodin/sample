package org.cnam.sample.dto;

import org.cnam.sample.domain.Libelle;
import org.cnam.sample.model.LibelleModel;

import java.sql.Date;

public class LibelleDto {

    private Long id_libelle;

    private String libelle_frais;

    private double montant_fixe;

    private double montant_pourcentage;


    public LibelleDto(){

    }

    public LibelleDto(long id_libelle, String libelle_frais, double montant_fixe, double montant_pourcentage){
        this.id_libelle = id_libelle;
        this.libelle_frais = libelle_frais;
        this.montant_fixe = montant_fixe;
        this.montant_pourcentage = montant_pourcentage;
    }

    public LibelleDto(Libelle libelle){
        this.id_libelle = libelle.getId_libelle();
        this.libelle_frais = libelle.getLibelle_frais();
        this.montant_fixe = libelle.getMontant_fixe();
        this.montant_pourcentage = libelle.getMontant_pourcentage();
    }

    public LibelleDto(LibelleModel libelle){
        this.id_libelle = libelle.getId_libelle();
        this.libelle_frais = libelle.getLibelle_frais();
        this.montant_fixe = libelle.getMontant_fixe();
        this.montant_pourcentage = libelle.getMontant_pourcentage();
    }

}
