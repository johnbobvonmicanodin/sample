package org.cnam.sample.service;

import org.cnam.sample.domain.Facture;
import org.cnam.sample.dto.FactureDto;
import org.cnam.sample.dto.NewFactureDto;
import org.cnam.sample.model.FactureModel;
import org.cnam.sample.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;

@Service
public class FactureService {

    @Autowired
    FactureRepository factureRepository;

    @Value("^$(application.courrier.url)")
    private String courrierApplicationURL;

    //creer courrier
    @Value("^$(application.courrier.feature.create)")
    private String creationCourrier;

    public Facture createNewFacture(long id_client, String libelle_frais, double montant, Date date){

        FactureModel factureModel = new FactureModel(id_client, libelle_frais, montant, date);
        FactureModel factureModelSaved = factureRepository.save(factureModel);

        return new Facture(factureModelSaved.getId(), factureModelSaved.getId_client(),
                            factureModelSaved.getLibelle_frais(), factureModelSaved.getMontant(),
                            factureModelSaved.getDate());
    }

    public Facture getFacture(long id){

        FactureModel factureModelFound = factureRepository.getOne(id);

        //return new Facture(factureModelFound.getId(), factureModelFound.getData());

        return new Facture();
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
    public void envoiCourrierFacture(){
        final RestTemplate restTemplate = new RestTemplate();
        //final String result1 = restTemplate.getForObject( url: courrierApplicationURL+ , String.class);

        //A voir les params courrier
        //final SampleRequest sampleRequest = new SampleRequest();

        //final String result2 = restTemplate.postForObject(courrierApplicationURL+creationCourrier, sampleRequest, String.class);
    }
}
