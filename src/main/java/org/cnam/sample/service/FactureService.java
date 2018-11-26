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

@Service
public class FactureService {

    @Autowired
    FactureRepository factureRepository;

    @Value("^$(application.facture.url)")
    private String clientApplicationURL;

    public Facture createNewFacture(String data){

        FactureModel factureModel = new FactureModel();
        FactureModel factureModelSaved = factureRepository.save(factureModel);

        //return new Facture(factureModelSaved.getId(), factureModelSaved.getData());

        //return new Facture(15102018L, data);

        return new Facture();
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
    /*public void envoiIdNewCompte(){
        final RestTemplate restTemplate = new RestTemplate();
        final String result1 = restTemplate.getForObject( url: "", String.class);
        final SampleRequest sampleRequest = new SampleRequest(id: 42, data: "");
        final String result2 = restTemplate.postForObject( url: "", sampleRequest, String.class);
    }*/
}
