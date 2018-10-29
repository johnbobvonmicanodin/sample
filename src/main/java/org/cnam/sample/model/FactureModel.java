package org.cnam.sample.model;

import javax.persistence.*;


@Entity
@Table(name = "sample")
public class FactureModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "data")
    private  String data;

    public FactureModel(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public FactureModel(String data){
        this.data = data;
    }
}
