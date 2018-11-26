package org.cnam.sample.dto;

import java.sql.Date;

public class NewFactureDto {

    public  Long id_client;

    public String libelle_frais;

    public double montant;

    public Date date;

    public NewFactureDto(){

    }

    public NewFactureDto(long id_client, String libelle_frais, double montant, Date date){
        //this.id = id;
        this.id_client = id_client;
        this.libelle_frais = libelle_frais;
        this.montant = montant;
        this.date = date;
    }
}
