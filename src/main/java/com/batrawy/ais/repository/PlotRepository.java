package com.batrawy.ais.repository;

import com.batrawy.ais.model.Plot;
import com.batrawy.ais.model.PlotStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlotRepository extends JpaRepository<Plot, Long> {

    @Query("from Plot p where p.deleted = false")
     List<Plot> getAllPlots();

    @Modifying(clearAutomatically = true)
    @Query("update Plot p set p.deleted = true where p.id =:id")
    void deletePlot(long id);

    @Query("Select p from Plot p join p.status  where p.status.startNextDate <= CURRENT_DATE And p.status.irrigationStatus = 'PENDING' ")
    List<Plot> getPlotToIrrigate();
}
