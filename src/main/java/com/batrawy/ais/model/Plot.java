package com.batrawy.ais.model;

import com.batrawy.ais.consts.MeasureUnit;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PLOT")
public class Plot extends BaseEntity {

    @Column(name = "SIZE")
    private Double size;

    @Column(name = "LABEL")
    private String label;

    @Column(name = "DAYS_TO_IRRIGATE")
    private long daysToIrrigate;

    @Enumerated(EnumType.STRING)
    @Column(name = "MEASURE_UNIT", length = 50)
    private MeasureUnit measureUnit;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plot")
    private List<PlotCoordinates> coordinates;

    @OneToOne( mappedBy = "plot" , cascade = CascadeType.ALL)
    private PlotStatus status;

    @ManyToOne
    private Corp corp;

    @Column(name = "DELETED")
    private boolean deleted;

    public Plot(Long plotId) {
        this.setId(plotId);
    }
}
