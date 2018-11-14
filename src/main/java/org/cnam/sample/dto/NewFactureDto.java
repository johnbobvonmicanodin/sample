package org.cnam.sample.dto;

import java.sql.Date;

public class NewFactureDto {

    private  Long id_client;

    private String libelle_frais;

    private double montant;

    private Date date;

    public NewFactureDto(){

    }

    /**public NewFactureDto(String data){
        this.data = data;
    }*/
}
