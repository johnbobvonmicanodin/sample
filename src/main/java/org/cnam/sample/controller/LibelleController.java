package org.cnam.sample.controller;

import org.cnam.sample.service.LibelleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
}
