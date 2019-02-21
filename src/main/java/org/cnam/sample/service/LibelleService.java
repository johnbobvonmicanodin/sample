package org.cnam.sample.service;

import org.cnam.sample.domain.Libelle;
import org.cnam.sample.model.LibelleModel;
import org.cnam.sample.repository.LibelleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LibelleService {

    @Autowired
    LibelleRepository libelleRepository;

    @Value("^$(application.libelle.url)")
    private String clientApplicationURL;

    /**public List<Libelle> savePerson(final Libelle person){

    }*/


    public Libelle getLibelle(long id){

        LibelleModel libelleModel = libelleRepository.getOne(id);

        return new Libelle(libelleModel.getId_libelle(), libelleModel.getLibelle_frais(), libelleModel.getMontant_fixe(), libelleModel.getMontant_pourcentage());
    }

    public Libelle createNewLibelle(long id_libelle, String libelle_frais, double montant_fixe, double montant_pourcentage){

        LibelleModel libelleModel = new LibelleModel(id_libelle, libelle_frais, montant_fixe, montant_pourcentage);
        LibelleModel libelleModelSaved = libelleRepository.save(libelleModel);



        return new Libelle(libelleModelSaved.getId_libelle(), libelleModelSaved.getLibelle_frais(),
                libelleModelSaved.getMontant_fixe(), libelleModelSaved.getMontant_pourcentage());
        
    }
}
