package com.batrawy.ais.service;


import com.batrawy.ais.repository.PlotStatusRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@AllArgsConstructor
@Service
public class PlotStatusService {
    private final PlotStatusRepository plotStatusRepository;

    @Transactional
    public void updatePlotStatus(long plotId){
        plotStatusRepository.updatePlotStatus(plotId);
    }
}
