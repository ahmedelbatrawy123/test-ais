package com.batrawy.ais.service;


import com.batrawy.ais.model.Corp;
import com.batrawy.ais.repository.CorpRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class CropService {
    private final CorpRepository corpRepository;
    public void addCrop(Corp corp) {
        corpRepository.save(corp);
    }

    public Corp getCropById(long id){
        return corpRepository.getById(id);
    }
}
