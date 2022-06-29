package com.batrawy.ais.dto;

import com.batrawy.ais.consts.IrrigationStatus;
import lombok.Data;

import java.time.LocalDate;


@Data
public class PlotStatusDto {

    private Long id;
    private IrrigationStatus irrigationStatus;
    private Integer period;
    private LocalDate startDate;
    private Integer waterIntensity;

}
