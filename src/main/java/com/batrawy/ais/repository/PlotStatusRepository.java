package com.batrawy.ais.repository;

import com.batrawy.ais.model.PlotStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface PlotStatusRepository extends JpaRepository<PlotStatus, Long> {

    @Modifying
    @Query(" update PlotStatus p set p.irrigationStatus = 'COMPLETED' where p.plot.id =:plotId")
    void updatePlotStatus(long plotId);
}
