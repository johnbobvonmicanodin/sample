package org.cnam.sample.controller;

import org.cnam.sample.domain.Facture;
import org.cnam.sample.dto.NewFactureDto;
import org.cnam.sample.dto.FactureDto;
import org.cnam.sample.dto.ResponseNewFactureDto;
import org.cnam.sample.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/facture")
public class FactureController {

    @Autowired
    public FactureService factureService;

    @PostMapping("/create")
    @ResponseBody
    public ResponseNewFactureDto createNewFacture(@RequestBody NewFactureDto newFactureDto){

        //UUID uuid = UUID.fromString(newFactureDto.id_client);

        Facture facture = factureService.createNewFacture(newFactureDto.id_client, newFactureDto.libelle_frais, newFactureDto.montant, newFactureDto.date);

        ResponseNewFactureDto rep = new ResponseNewFactureDto(true,"Succès de la création de la facture");

        if(facture.getLibelle_frais() == null){
            rep.setMessage("Echec de la création de facture");
            rep.setSuccess(false);
        }

        return rep;
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public FactureDto getFacture(@PathVariable Long id){
        FactureDto factureDto = new FactureDto();

        Facture facture = factureService.getFacture(id);

        return new FactureDto(facture);
    }

    @GetMapping("/getforclient/{id}")
    @ResponseBody
    public FactureDto getFactureForClient (@PathVariable UUID id){

        return new FactureDto();
    }

}
