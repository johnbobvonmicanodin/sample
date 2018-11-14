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

    public Facture createNewSample(String data){

        FactureModel factureModel = new FactureModel();
        FactureModel factureModelSaved = factureRepository.save(factureModel);

        //return new Facture(factureModelSaved.getId(), factureModelSaved.getData());

        //return new Facture(15102018L, data);

        return new Facture();
    }

    public Facture getSample(long id){

        FactureModel factureModelFound = factureRepository.getOne(id);

        //return new Facture(factureModelFound.getId(), factureModelFound.getData());

        return new Facture();
    }

    public Facture createNewSampleExternal(String data){
        RestTemplate restTemplate = new RestTemplate();
        NewFactureDto facture = new NewFactureDto();
        //FactureDto myFacture = restTemplate.postForObject(clientApplicationURL + "something");

        //Log
        //LOGGER.info(myFacture.toString());

        Facture facture1 = new Facture();

        return facture1;
    }
}
