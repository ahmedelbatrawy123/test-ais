package com.batrawy.ais.service;


import com.batrawy.ais.dto.request.IrrigateInfoDto;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public interface SensorService {

    @Retryable(value = { Exception.class }, maxAttemptsExpression = "${retry.maxAttempts}", backoff = @Backoff(delayExpression = "${retry.delay}"))
     void callSensor(IrrigateInfoDto irrigateInfoDto);
}