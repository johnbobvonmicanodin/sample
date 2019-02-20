package org.cnam.sample.dto;

public class EmailTemplateDto {

    private String subject;
    private String body;
    private String serviceName;

    public EmailTemplateDto(String subject, String body, String serviceName) {
        // Sujet de l'email
        this.subject = subject;

        // Contenu de l'email
        this.body = body;

        // ServiceName
        this.serviceName = serviceName;
    }
}