package org.cnam.sample.dto;
import java.sql.Date;


public class FactureDto {

    private Long id;

    private  Long id_client;

    private String libelle_frais;

    private double montant;

    private Date date;

    public FactureDto(){

    }

    public FactureDto(long id, long id_client, String libelle_frais, double montant, Date date){
        this.id = id;
        this.id_client = id_client;
        this.libelle_frais = libelle_frais;
        this.montant = montant;
        this.date = date;
    }
}
