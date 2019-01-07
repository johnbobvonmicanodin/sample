package org.cnam.sample.dto;

import java.util.HashMap;

public class Email {

    // Personne à qui l'on envoie l'email
    private String recipient;

    // HashMap clé/valeur : pour remplacer les valeurs dans le template choisi
    private HashMap<String,String> values;

    public Email(String recipient, HashMap<String, String> values) {
        this.recipient = recipient;
        this.values = values;
    }
}