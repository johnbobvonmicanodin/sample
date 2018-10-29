package org.cnam.sample.controller;

import org.cnam.sample.domain.Facture;
import org.cnam.sample.dto.NewFactureDto;
import org.cnam.sample.dto.FactureDto;
import org.cnam.sample.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sample")
public class FactureController {

    @Autowired
    public FactureService factureService;

    @PostMapping("/create")
    @ResponseBody
    public FactureDto createNewSample(@RequestBody NewFactureDto newFactureDto){
        Facture facture = factureService.createNewSample(newFactureDto.data);

        return new FactureDto(facture.id, facture.data);
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public FactureDto getSample(@PathVariable Long id){
        FactureDto factureDto = new FactureDto();

        Facture facture = factureService.getSample(id);

        return new FactureDto(facture.id, facture.data);
    }

}
