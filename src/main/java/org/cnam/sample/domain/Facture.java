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

    /*public Facture(long id, String data){
        this.id = id;
        this.data = data;
    }*/
}

