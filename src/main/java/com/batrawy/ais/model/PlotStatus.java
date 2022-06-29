package com.batrawy.ais.model;

import com.batrawy.ais.consts.IrrigationStatus;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "PLOT_STATUS")
public class PlotStatus extends BaseEntity {

    @OneToOne()
    private Plot plot;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", length = 50)
    private IrrigationStatus irrigationStatus;

    /**
     * Start irrigation time.
     */
    @Column(name = "START_DATE")
    private LocalDate startDate;


    @Column(name = "START_NEXT_DATE")
    private LocalDate startNextDate;
    /**
     * Amount of irrigation time (in minutes) a plot should be given.
     */
    @Min(1)
    @Max(1440)
    @Column(name = "PERIOD")
    private Integer period;

    /**
     * Intensity (percentage) of the water sprinklers power.
     * Min is 1 and max is 100.
     */
    @Min(1)
    @Max(100)
    @Column(name = "WATER_INTENSITY")
    private Integer waterIntensity;

}
