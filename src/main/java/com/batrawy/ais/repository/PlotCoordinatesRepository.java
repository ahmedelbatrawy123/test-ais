package com.batrawy.ais.repository;

import com.batrawy.ais.model.PlotCoordinates;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlotCoordinatesRepository extends JpaRepository<PlotCoordinates, Long> {

     List<PlotCoordinates> findByPlotId(Long plotID);

     void deleteAllByPlotId(Long plotID);
}
