package org.cnam.sample.controller;

import org.cnam.sample.domain.Libelle;
import org.cnam.sample.dto.LibelleDto;
import org.cnam.sample.dto.NewLibelleDto;
import org.cnam.sample.dto.ResponseNewLibelleDto;
import org.cnam.sample.service.LibelleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/person")
public class LibelleController {

    @Autowired
    public LibelleService libelleService;

    /**@PostMapping("/saveperson")
    @ReponseBody
    public List<SavePersonResponse> savePerson(final SaveLibelleRequest){

        return null;
    }*/

    @GetMapping("/get/{id}")
    @ResponseBody
    public LibelleDto getLibelle(@PathVariable Long id){
        LibelleDto libelleDto = new LibelleDto();

        Libelle libelle = libelleService.getLibelle(id);

        //return new FactureDto(facture.id, facture.data);
        return new LibelleDto();
    }


    @PostMapping("/create")
    @ResponseBody
    public ResponseNewLibelleDto createNewLibelle(@RequestBody NewLibelleDto newLibelleDto){

        Libelle libelle = libelleService.createNewLibelle(newLibelleDto.id_libelle, newLibelleDto.libelle_frais, newLibelleDto.montant_fixe, newLibelleDto.montant_pourcentage);

        ResponseNewLibelleDto rep = new ResponseNewLibelleDto(true, "Succès de la création du libellé");



        if(libelle.getLibelle_frais() == null){
            rep.setMessage("Echec de la création du libellé");
            rep.setSuccess(false);
        }

        return rep;
    }
}
