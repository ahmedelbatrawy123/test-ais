package com.batrawy.ais.service;

import com.batrawy.ais.dto.request.IrrigateInfoDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@AllArgsConstructor
public class SensorServiceImpl implements SensorService {


    private RestTemplate restTemplate;
    private PlotStatusService plotStatusService;


    @Value("${retry.maxAttempts}")
    static int retryCount;

    @Override
    public void callSensor(IrrigateInfoDto irrigateInfoDto) {


        String status = restTemplate.getForObject("http://localhost:8099/mock/irrigate",
                String.class);
        if ("success".equalsIgnoreCase(status)) {
    //update plot status
            plotStatusService.updatePlotStatus(irrigateInfoDto.getPoltId());
        }

    }
}
