package org.cnam.sample.dto;

public class SendEmailDto {

    // Voir ci-dessous
    private Email email;

    // Nom de votre service
    private String service;

    public SendEmailDto(Email email,String service){
        this.email = email;
        this.service = service;
    }
}