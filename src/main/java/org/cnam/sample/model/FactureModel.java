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

    //Constructeur avec paramètres
    /**public FactureModel(String data){
        this.data = data;
    }
     */

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
