package com.batrawy.ais.service;

import com.batrawy.ais.dto.request.IrrigateInfoDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@AllArgsConstructor
public class SensorServiceImpl implements SensorService {


    public static final String SCENSOR_MOCK_URL = "http://localhost:8099/mock/irrigate";
    private RestTemplate restTemplate;
    private PlotStatusService plotStatusService;


    @Value("${retry.maxAttempts}")
    static int retryCount;

    @Override
    public void callSensor(IrrigateInfoDto irrigateInfoDto) {


        ResponseEntity<String> status = restTemplate.postForEntity(SCENSOR_MOCK_URL,irrigateInfoDto,
                String.class);
        if ("success".equalsIgnoreCase(status.getBody())) {
            plotStatusService.updatePlotStatus(irrigateInfoDto.getPoltId());
        }else{
            log.warn("SENSOR Failed to irrigate");
        }

    }
}
