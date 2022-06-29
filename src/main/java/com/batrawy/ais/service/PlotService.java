package com.batrawy.ais.service;

import com.batrawy.ais.dto.PlotDto;
import com.batrawy.ais.mapper.PlotMapper;
import com.batrawy.ais.model.Plot;
import com.batrawy.ais.model.PlotStatus;
import com.batrawy.ais.repository.PlotRepository;
import com.batrawy.ais.repository.PlotStatusRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@Slf4j
@AllArgsConstructor
@Service
public class PlotService {

    private final PlotRepository plotRepo;
    private final PlotStatusRepository plotStatusRepository;
    private final PlotMapper plotMapper;
    private final CropService cropService;

    public List<PlotDto> getAllPlots() {
        List<Plot> plots = plotRepo.getAllPlots();
        return plotMapper.fromModelToDtoAsList(plots);
    }

    public PlotDto getPlotInfo(Long plotId) {
        return plotMapper.fromModelToDto(plotRepo.getById(plotId));
    }

    public Plot getPlot(Long plotId) {
        return plotRepo.getById(plotId);
    }

    @Transactional
    public void savePlot(PlotDto plotDto) {
        Plot plot = plotMapper.fromDtoToModel(plotDto);
        PlotStatus plotStatus = plot.getStatus();
        plotStatus.setStartNextDate(calculateNextIrrigationDate(plotStatus.getStartDate(), plot.getDaysToIrrigate()));
        plotStatus = plotStatusRepository.save(plotStatus);
        if (plotDto.getCropId() != null) {
            plot.setCorp(cropService.getCropById(plotDto.getCropId()));
        }
        plot = plotRepo.save(plot);
        plot.setStatus(plotStatus);
        plotStatus.setPlot(plot);
        plotRepo.save(plot);
    }

    private LocalDate calculateNextIrrigationDate(LocalDate startDate, Long daysToIrrigate) {
        return startDate.plusDays(daysToIrrigate);
    }

    @Transactional
    public void deletePlot(long id) {
        this.plotRepo.deletePlot(id);
    }

    public List<Plot> getPlotToIrrigate() {
    return plotRepo.getPlotToIrrigate();
    }
}
