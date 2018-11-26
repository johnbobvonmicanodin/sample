package org.cnam.sample.domain;

import java.sql.Date;

public class Facture {

    private Long id;

    private  Long id_client;

    private String libelle_frais;

    private double montant;

    private Date date;

    public Facture(){

    }

    public Facture(long id, long id_client, String libelle_frais, double montant, Date date){
        this.id = id;
        this.id_client = id_client;
        this.libelle_frais = libelle_frais;
        this.montant = montant;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public Long getId_client() {
        return id_client;
    }

    public String getLibelle_frais() {
        return libelle_frais;
    }

    public double getMontant() {
        return montant;
    }

    public Date getDate() {
        return date;
    }
}

