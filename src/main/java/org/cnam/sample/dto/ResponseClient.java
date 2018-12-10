package org.cnam.sample.dto;

import java.io.Serializable;
import java.util.UUID;


public class ResponseClient implements Serializable {

    private String id;

    private String lastName;

    private String firstName;

    private String mail;

    private String birthDate;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ResponseClient() {
    }

    public ResponseClient(String id, String lastName, String firstName, String mail, String birthDate) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.mail = mail;
        this.birthDate = birthDate;
    }

    /*public ClientDto(Client client){
        this.id = client.getId();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.mail = client.getMail();
        this.birthDate = client.getBirthDate();
    }*/

}
