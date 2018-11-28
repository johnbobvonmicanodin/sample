package org.cnam.sample.dto;

import java.sql.Date;
import java.util.UUID;

public class NewFactureDto {

    public UUID id_client;

    public String libelle_frais;

    public double montant;

    public Date date;

    public NewFactureDto(){

    }

    public NewFactureDto(UUID id_client, String libelle_frais, double montant, Date date){
        //this.id = id;
        this.id_client = id_client;
        this.libelle_frais = libelle_frais;
        this.montant = montant;
        this.date = date;
    }
}
