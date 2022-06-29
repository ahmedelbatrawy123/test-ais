package com.batrawy.ais.repository;

import com.batrawy.ais.model.PlotStatusIrrigationHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IrrigationHistoryRepository extends JpaRepository<PlotStatusIrrigationHistory, Long> {
}
