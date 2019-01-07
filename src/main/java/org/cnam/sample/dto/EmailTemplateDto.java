package org.cnam.sample.dto;

public class EmailTemplateDto {

    private String subject;
    private String body;

    public EmailTemplateDto(String subject, String body) {
        // Sujet de l'email
        this.subject = subject;

        // Contenu de l'email
        this.body = body;
    }
}