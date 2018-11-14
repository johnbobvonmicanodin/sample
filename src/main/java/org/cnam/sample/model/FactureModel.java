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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //Constructeur avec paramètres
    /**public FactureModel(String data){
        this.data = data;
    }

    //public String getData(){
        return "Hello";
    }*/
}
