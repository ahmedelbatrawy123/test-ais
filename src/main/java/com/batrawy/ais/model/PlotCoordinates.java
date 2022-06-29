package com.batrawy.ais.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PLOT_COORDINATES")
public class PlotCoordinates extends BaseEntity {

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Plot plot;

    @Column(name = "LATITUDE")
    private Double latitude;

    @Column(name = "LONGITUDE")
    private Double longitude;

}
