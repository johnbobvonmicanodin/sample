package org.cnam.sample.controller;

import org.cnam.sample.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.cnam.sample.dto.SavePersonRequest;
import org.cnam.sample.dto.SavePersonReponse;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    public PersonService personService;

    /**@PostMapping("/saveperson")
    @ReponseBody
    public List<SavePersonResponse> savePerson(final SavePersonRequest){

        return null;
    }*/
}
