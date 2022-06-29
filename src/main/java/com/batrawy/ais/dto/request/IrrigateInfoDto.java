package com.batrawy.ais.dto.request;

import lombok.Data;

@Data
public class IrrigateInfoDto {
    private Long poltId;
    private String notes;
    private Integer recommendedIrrigationPeriod;
    private Integer recommendedWaterIntensity;
    private Integer period;

}
