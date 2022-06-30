package com.batrawy.ais.service;


import com.batrawy.ais.dto.PlotCoordinatesDto;
import com.batrawy.ais.dto.request.PlotCoordinatesRequestDto;
import com.batrawy.ais.exception.InvalidCoordinatesException;
import com.batrawy.ais.mapper.PlotCoordinatesMapper;
import com.batrawy.ais.repository.PlotCoordinatesRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class CoordinatesService {

    private final PlotCoordinatesRepository coordinatesRepo;
    private final PlotCoordinatesMapper plotCoordinatesMapper;

    public List<PlotCoordinatesDto> getPlotCoordinates(Long plotID) {
        return plotCoordinatesMapper.fromPlotCoordinateslToDtoAsLsit(coordinatesRepo.findByPlotId(plotID)) ;
    }

    @Transactional
    public void assignPlotCoordinates(PlotCoordinatesRequestDto coordinates) {
       if(coordinates.getPlotCoordinatesList() == null || coordinates.getPlotCoordinatesList().size() != 4){
           throw new InvalidCoordinatesException(" invalide coordinates Must be not empty or size not equal 4");
       }
        this.coordinatesRepo.deleteAllByPlotId(coordinates.getPlotId());
      this.coordinatesRepo.saveAll(plotCoordinatesMapper.fromDtoToModelAsList(coordinates));
    }
}
