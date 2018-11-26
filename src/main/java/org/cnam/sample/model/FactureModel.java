package org.cnam.sample.model;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "facture")
public class FactureModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_client")
    private  Long id_client;

    @Column(name = "libelle_frais")
    private String libelle_frais;

    @Column(name = "montant")
    private double montant;

    @Column(name = "date")
    private Date date;

    public FactureModel(){

    }

    public FactureModel(long id_client, String libelle_frais, double montant, Date date){
        this.id_client = id_client;
        this.libelle_frais = libelle_frais;
        this.montant = montant;
        this.date = date;
    }

    public FactureModel(long id, long id_client, String libelle_frais, double montant, Date date){
        this.id = id;
        this.id_client = id_client;
        this.libelle_frais = libelle_frais;
        this.montant = montant;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
