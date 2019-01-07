package org.cnam.sample.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;


@Entity
@Table(name = "facture")
public class FactureModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "idClient")
    private UUID idClient;

    @Column(name = "libelle_frais")
    private String libelle_frais;

    @Column(name = "montant")
    private double montant;

    @Column(name = "date")
    private Date date;

    public FactureModel(){

    }

    public FactureModel(UUID idClient, String libelle_frais, double montant, Date date){
        this.idClient = idClient;
        this.libelle_frais = libelle_frais;
        this.montant = montant;
        this.date = date;
    }

    public FactureModel(long id, UUID idClient, String libelle_frais, double montant, Date date){
        this.id = id;
        this.idClient = idClient;
        this.libelle_frais = libelle_frais;
        this.montant = montant;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UUID getIdClient() {
        return idClient;
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
