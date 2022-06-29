package com.batrawy.ais.dto;

import com.batrawy.ais.consts.MeasureUnit;
import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class PlotDto {
    private Long id;
    private Double size;
    @NotNull
    private Long daysToIrrigate;
    private MeasureUnit measureUnit;
    private String name;
    private String label;
    private PlotStatusDto status;
    private Long cropId;

}
