package org.cnam.sample.service;

import org.cnam.sample.domain.Sample;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    public Sample createNewSample(String data){
        return new Sample(15102018L, data);
    }

    public Sample getSample(long id){
        return new Sample(id, "Hello World");
    }
}
