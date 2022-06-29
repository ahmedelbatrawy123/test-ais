package com.batrawy.ais.model;

import com.batrawy.ais.consts.IrrigationStatus;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Data
@Entity
@Table(name = "IRRIGATION_HISTORY")
public class PlotStatusIrrigationHistory extends BaseEntity {

    @OneToOne
    private Plot plot;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", length = 50)
    private IrrigationStatus status;

    /**
     * Start irrigation time.
     */
    @Column(name = "START_TIME", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

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

    /**
     * Finish irrigation time.
     */
    @Column(name = "FINISH_TIME", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finishTime;

}
