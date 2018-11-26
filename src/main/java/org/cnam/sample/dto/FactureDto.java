package org.cnam.sample.dto;
import org.cnam.sample.domain.Facture;

import java.sql.Date;


public class FactureDto {

    public Long id;

    public  Long id_client;

    public String libelle_frais;

    public double montant;

    public Date date;

    public FactureDto(){

    }

    public FactureDto(long id, long id_client, String libelle_frais, double montant, Date date){
        this.id = id;
        this.id_client = id_client;
        this.libelle_frais = libelle_frais;
        this.montant = montant;
        this.date = date;
    }

    public FactureDto(Facture facture){
        this.id = facture.getId();
        this.id_client = facture.getId_client();
        this.date = facture.getDate();
        this.libelle_frais = facture.getLibelle_frais();
        this.montant = facture.getMontant();
    }
}
