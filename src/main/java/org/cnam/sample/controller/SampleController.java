package org.cnam.sample.controller;

import org.cnam.sample.domain.Sample;
import org.cnam.sample.dto.NewSampleDto;
import org.cnam.sample.dto.SampleDto;
import org.cnam.sample.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sample/")
public class SampleController {

    @Autowired
    public SampleService sampleService;

    @PostMapping("/create")
    @ResponseBody
    public SampleDto createNewSample(@RequestBody NewSampleDto newSampleDto){
        Sample sample = sampleService.createNewSample(newSampleDto.data);

        return new SampleDto(sample.id, sample.data);
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public SampleDto getSample(@PathVariable Long id){
        SampleDto sampleDto = new SampleDto();

        Sample sample = sampleService.getSample(id);

        return new SampleDto(sample.id, sample.data);
    }

}
