package org.cnam.sample.domain;

public class Libelle {

    private Long id_libelle;

    private String libelle_frais;

    private double montant_fixe;

    private double montant_pourcentage;

    public Libelle(){

    }

    public Libelle(final String libelle_frais){
        this.libelle_frais = libelle_frais;
    }
}
