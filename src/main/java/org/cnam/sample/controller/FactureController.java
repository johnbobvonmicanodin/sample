package org.cnam.sample.controller;

import org.cnam.sample.domain.Facture;
import org.cnam.sample.dto.NewFactureDto;
import org.cnam.sample.dto.FactureDto;
import org.cnam.sample.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/facture")
public class FactureController {

    @Autowired
    public FactureService factureService;

    @PostMapping("/create")
    @ResponseBody
    public FactureDto createNewFacture(@RequestBody NewFactureDto newFactureDto){


        System.out.println("Hello world");
        System.out.println(newFactureDto.id_client);

        Facture facture = factureService.createNewFacture(newFactureDto.id_client, newFactureDto.libelle_frais, newFactureDto.montant, newFactureDto.date);

        return new FactureDto(facture);
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public FactureDto getFacture(@PathVariable Long id){
        FactureDto factureDto = new FactureDto();

        Facture facture = factureService.getFacture(id);

        //return new FactureDto(facture.id, facture.data);
        return new FactureDto(facture);
    }

}
