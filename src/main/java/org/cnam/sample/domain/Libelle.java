package org.cnam.sample.domain;

public class Libelle {

    private Long id_libelle;

    private String libelle_frais;

    private double montant_fixe;

    private double montant_pourcentage;

    public Libelle(){

    }

    public Libelle(long id_libelle, final String libelle_frais, double montant_fixe, double montant_pourcentage){
        this.id_libelle = id_libelle;
        this.libelle_frais = libelle_frais;
        this.montant_fixe = montant_fixe;
        this.montant_pourcentage = montant_pourcentage;
    }

    public Long getId_libelle() {
        return id_libelle;
    }

    public final String getLibelle_frais() {
        return libelle_frais;
    }

    public double getMontant_fixe() {
        return montant_fixe;
    }

    public double getMontant_pourcentage() {
        return montant_pourcentage;
    }
}
