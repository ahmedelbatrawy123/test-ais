package com.batrawy.ais.model;

import com.batrawy.ais.consts.SoilType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CORP")
public class Corp extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "NOTES")
    private String notes;

    @Min(1)
    @Max(1440)
    @Column(name = "RECOMMENDED_PERIOD")
    private Integer recommendedIrrigationPeriod;

    @Min(1)
    @Max(100)
    @Column(name = "RECOMMENDED_WATER_INTENSITY")
    private Integer recommendedWaterIntensity;

    @Enumerated(EnumType.STRING)
    @Column(name = "RECOMMENDED_SOIL_TYPE", length = 50)
    private SoilType recommendedSoilType;

}
