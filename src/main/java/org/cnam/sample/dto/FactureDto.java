package org.cnam.sample.dto;
import org.cnam.sample.domain.Facture;
import org.cnam.sample.model.FactureModel;

import java.sql.Date;
import java.util.UUID;


public class FactureDto {

    public Long id;

    public UUID id_client;

    public String libelle_frais;

    public double montant;

    public Date date;

    public FactureDto(){

    }

    public FactureDto(long id, UUID id_client, String libelle_frais, double montant, Date date){
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

    public FactureDto(FactureModel facture){
        this.id = facture.getId();
        this.id_client = facture.getIdClient();
        this.date = facture.getDate();
        this.libelle_frais = facture.getLibelle_frais();
        this.montant = facture.getMontant();
    }
}
