package org.cnam.sample.dto;

import org.cnam.sample.domain.Libelle;

import java.sql.Date;

public class LibelleDto {

    private Long id_libelle;

    private String libelle_frais;

    private double montant_fixe;

    private double montant_pourcentage;


    public LibelleDto(){

    }

    public LibelleDto(String libelle_frais, double montant_fixe, double montant_pourcentage){

        this.libelle_frais = libelle_frais;
        this.montant_fixe = montant_fixe;
        this.montant_pourcentage = montant_pourcentage;
    }


}
