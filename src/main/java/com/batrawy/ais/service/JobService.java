package com.batrawy.ais.service;


import com.batrawy.ais.dto.request.IrrigateInfoDto;
import com.batrawy.ais.mapper.IrrigateInfoMapper;
import com.batrawy.ais.model.Plot;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class JobService {


    private final PlotService plotService;
    private final IrrigateInfoMapper irrigateInfoMapper;
    private final SensorServiceImpl sensorService;

    //    @Scheduled(cron = "0 * * ? * *")
    @Scheduled(cron = "* * * ? * *")
    public void getPlotToIrrigate() {

        List<Plot> plotList = plotService.getPlotToIrrigate();
        // fill irrigate info object
        // call sensor
        plotList.forEach(plot -> {
            try {
                IrrigateInfoDto irrigateInfoDto = predictIrrigationData(plot);
                sensorService.callSensor(irrigateInfoDto);
            } catch (HttpClientErrorException exception) {
                log.warn("Alert Plot with label {} calling sensor fail ", plot.getLabel());

            }
        });

    }

    private IrrigateInfoDto predictIrrigationData(Plot plot) {
        IrrigateInfoDto irrigateInfoDto = irrigateInfoMapper.fromCropToIrrigateInfo(plot.getCorp());
        irrigateInfoDto.setPeriod(plot.getStatus().getPeriod());
        irrigateInfoDto.setPoltId(plot.getId());
        return irrigateInfoDto;
    }

}
