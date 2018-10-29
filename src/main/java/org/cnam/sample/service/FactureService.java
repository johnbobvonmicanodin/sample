package org.cnam.sample.service;

import org.cnam.sample.domain.Facture;
import org.cnam.sample.model.FactureModel;
import org.cnam.sample.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactureService {

    @Autowired
    FactureRepository factureRepository;

    public Facture createNewSample(String data){

        FactureModel factureModel = new FactureModel(data);
        FactureModel factureModelSaved = factureRepository.save(factureModel);

        return new Facture(factureModelSaved.getId(), factureModelSaved.getData());

        //return new Facture(15102018L, data);
    }

    public Facture getSample(long id){

        FactureModel factureModelFound = factureRepository.getOne(id);

        return new Facture(factureModelFound.getId(), factureModelFound.getData());

        //return new Facture(id, "Hello World");
    }
}
