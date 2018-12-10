package org.cnam.sample.service;

import org.cnam.sample.domain.Facture;
import org.cnam.sample.dto.FactureDto;
import org.cnam.sample.dto.NewFactureDto;
import org.cnam.sample.dto.ResponseClient;
import org.cnam.sample.model.FactureModel;
import org.cnam.sample.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.rmi.server.UID;
import java.sql.Date;
import java.util.*;

@Service
public class FactureService {

    @Autowired
    FactureRepository factureRepository;

    @Value("^$(application.courrier.url)")
    private String courrierApplicationURL;

    //creer courrier
    @Value("^$(application.courrier.feature.create)")
    private String creationCourrier;

    @Value("^$(application.client.url)")
    private  String clientURL;

    @Value("^$(application.client.url)")
    private  String creationClient;

    public Facture createNewFacture(UUID id_client, String libelle_frais, double montant, Date date){

        FactureModel factureModel = new FactureModel(id_client, libelle_frais, montant, date);
        FactureModel factureModelSaved = factureRepository.save(factureModel);

        envoiCourrierFacture(new Facture(factureModelSaved.getId(), factureModelSaved.getId_client(),
                factureModelSaved.getLibelle_frais(), factureModelSaved.getMontant(),
                factureModelSaved.getDate()));

        return new Facture(factureModelSaved.getId(), factureModelSaved.getId_client(),
            factureModelSaved.getLibelle_frais(), factureModelSaved.getMontant(),
            factureModelSaved.getDate());
}

    public Facture getFacture(Long id){

        FactureModel factureModelSaved = factureRepository.getOne(id);

        return new Facture(factureModelSaved.getId(), factureModelSaved.getId_client(),
                factureModelSaved.getLibelle_frais(), factureModelSaved.getMontant(),
                factureModelSaved.getDate());
    }


    public ArrayList<Facture> getAllForUUID(UUID id_client){
        ArrayList<Facture> listeFacture = new ArrayList<Facture>();

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
        System.out.println(clientURL+creationClient+String.valueOf(facture.getId_client()));

        final RestTemplate restTemplate = new RestTemplate();

        String ClientURL = "http://cnam-nfe107.k8s.grobert.fr/client/"+String.valueOf(facture.getId_client());
        System.out.println(ClientURL);

        //http://cnam-nfe107.k8s.grobert.fr/client/get/
        //final ResponseClient client = restTemplate.getForObject(clientURL+creationClient+String.valueOf(facture.getId_client()),ResponseClient.class);
        ResponseClient client = restTemplate.getForObject("http://cnam-nfe107.k8s.grobert.fr/client/"+String.valueOf(facture.getId_client()),ResponseClient.class);

        String firstName = client.getFirstName();
        String lastName = client.getLastName();
        String mail = client.getMail();

        System.out.println(firstName+' '+lastName+' '+mail);

        String serviceName = "Facture";
        HashMap<String, String> values = new HashMap<String, String>();

        values.put("Libelle",facture.getLibelle_frais());
        values.put("Montant de la facture",String.valueOf(facture.getMontant()));

        String recipient = "";

        //final String result1 = restTemplate.getForObject( url: courrierApplicationURL+ , String.class);

        //A voir les params courrier
        //final SampleRequest sampleRequest = new SampleRequest();

        //final String result2 = restTemplate.postForObject(courrierApplicationURL+creationCourrier, sampleRequest, String.class);
    }
}
