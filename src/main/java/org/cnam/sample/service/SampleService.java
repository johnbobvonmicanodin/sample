package org.cnam.sample.service;

import org.cnam.sample.domain.Sample;
import org.cnam.sample.model.SampleModel;
import org.cnam.sample.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    @Autowired
    SampleRepository sampleRepository;

    public Sample createNewSample(String data){

        SampleModel sampleModel = new SampleModel(data);
        SampleModel sampleModelSaved = sampleRepository.save(sampleModel);

        return new Sample(sampleModelSaved.getId(), sampleModelSaved.getData());

        //return new Sample(15102018L, data);
    }

    public Sample getSample(long id){

        SampleModel sampleModelFound = sampleRepository.getOne(id);

        return new Sample(sampleModelFound.getId(), sampleModelFound.getData());

        //return new Sample(id, "Hello World");
    }
}
