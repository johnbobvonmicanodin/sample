package org.cnam.sample.service;

import org.cnam.sample.domain.Facture;
import org.cnam.sample.dto.*;
import org.cnam.sample.model.FactureModel;
import org.cnam.sample.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.util.*;

@Service
public class FactureService {

    @Autowired
    FactureRepository factureRepository;

    @Value("${application.courrier.url}")
    private String courrierApplicationURL;

    //creer courrier
    @Value("${application.courrier.feature.create}")
    private String creationCourrier;

    //envoyer courrier
    @Value("${application.courrier.feature.send}")
    private String sendMail;

    @Value("${application.client.url}")
    private  String clientURL;

    @Value("${application.client.feature.get}")
    private  String creationClient;

    public Facture createNewFacture(UUID id_client, String libelle_frais, double montant, Date date){

        FactureModel factureModel = new FactureModel(id_client, libelle_frais, montant, date);
        FactureModel factureModelSaved = factureRepository.save(factureModel);

        try{
            envoiCourrierFacture(new Facture(factureModelSaved.getId(), factureModelSaved.getIdClient(),
                    factureModelSaved.getLibelle_frais(), factureModelSaved.getMontant(),
                    factureModelSaved.getDate()));
        } catch (Exception e) {
            System.out.println("error envoi courrier");
        }

        return new Facture(factureModelSaved.getId(), factureModelSaved.getIdClient(),
            factureModelSaved.getLibelle_frais(), factureModelSaved.getMontant(),
            factureModelSaved.getDate());
}

    public Facture getFacture(Long id){

        FactureModel factureModelSaved = factureRepository.getOne(id);

        return new Facture(factureModelSaved.getId(), factureModelSaved.getIdClient(),
                factureModelSaved.getLibelle_frais(), factureModelSaved.getMontant(),
                factureModelSaved.getDate());
    }


    public List<FactureModel> getAllForUUID(UUID idClient){

        List<FactureModel> listeFacture = factureRepository.findByIdClient(idClient);

        return listeFacture;
    }

    public Facture createNewFactureExternal(String data){
        RestTemplate restTemplate = new RestTemplate();
        NewFactureDto facture = new NewFactureDto();
        //FactureDto myFacture = restTemplate.postForObject(clientApplicationURL + "something");

        //Log
        //LOGGER.info(myFacture.toString());

        Facture facture1 = new Facture();

        return facture1;
    }

    //Connexion api exemple
    public void envoiCourrierFacture(Facture facture){

        System.out.println("Hello Facture");

        final RestTemplate restTemplate = new RestTemplate();

        String clientURLFull = clientURL+creationClient+String.valueOf(facture.getId_client());

        System.out.println(clientURLFull);

        //http://cnam-nfe107.k8s.grobert.fr/client/get/
        ResponseClient client = restTemplate.getForObject(clientURLFull,ResponseClient.class);

        String service = "Facture";
        String firstName = client.getFirstName();
        String lastName = client.getLastName();
        String mail = client.getMail();

        //String firstName = "test";
        //String lastName = "test";
        //String mail = "mailtest";

        String sujet = "Facture : "+facture.getLibelle_frais();
        String body = "Bonjour Monsieur/Madame{prenom} {nom}\n Veuillez trouver ci joint le montant et le sujet de votre facture :\n"
                    + "{libelle} : {montant} €.\n Cordialement\n Le Service Facturation";

        System.out.println(firstName+' '+lastName+' '+mail);

        HashMap<String, String> values = new HashMap<String, String>();

        values.put("{libelle}",facture.getLibelle_frais());
        values.put("{montant}",String.valueOf(facture.getMontant()));
        values.put("{prenom}", firstName);
        values.put("{nom}", lastName);

        String recipient = mail;

        EmailTemplateDto emailTemplate = new EmailTemplateDto(sujet, body, service);
        Email emailDto = new Email(recipient, values);
        SendEmailDto sendEmail = new SendEmailDto(emailDto, service);

        System.out.println(courrierApplicationURL+sendMail);

        //HttpEntity<EmailTemplateDto> requestTemplate = new HttpEntity<EmailTemplateDto>(emailTemplate);
        //EmailTemplateDto retourTemplate = restTemplate.postForObject(courrierApplicationURL+creationCourrier, emailTemplate, EmailTemplateDto.class);

        SendEmailDto retourSend = restTemplate.postForObject(courrierApplicationURL+sendMail, sendEmail, SendEmailDto.class);

        /*FactureDto testPost = new FactureDto();
        testPost.id_client = UUID.fromString("ee970f8f-905c-48f1-bd1b-8a7d0edc27f7");
        testPost.montant = 10.58;
        testPost.libelle_frais = "TestLibelleFrais";

        FactureDto sendFacture = restTemplate.postForObject("http://localhost:8085/facture/create", testPost, FactureDto.class);*/

        System.out.println("envoyé");
    }
}
