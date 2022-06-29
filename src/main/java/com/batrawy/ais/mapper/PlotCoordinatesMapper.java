package com.batrawy.ais.mapper;


import com.batrawy.ais.dto.PlotCoordinatesDto;
import com.batrawy.ais.dto.request.PlotCoordinatesRequestDto;
import com.batrawy.ais.model.Plot;
import com.batrawy.ais.model.PlotCoordinates;
import com.batrawy.ais.service.PlotService;
import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PlotCoordinatesMapper {

    @Autowired
    private PlotService plotService;

    @Mapping(source = "plotId", target = "plot")
    abstract PlotCoordinates fromDtoToModel(PlotCoordinatesDto dto);

    @Mapping(source = "plot.id", target = "plotId")
    abstract PlotCoordinatesDto fromModelToDto(PlotCoordinates model);

    public abstract List<PlotCoordinatesDto> fromPlotCoordinateslToDtoAsLsit(List<PlotCoordinates> dtoList);

    public List<PlotCoordinates> fromDtoToModelAsList(PlotCoordinatesRequestDto dto) {
        List<PlotCoordinates> plotCoordinates = new ArrayList<>();
        dto.getPlotCoordinatesList().forEach(plotCoordinatesDto -> plotCoordinates.add(new PlotCoordinates(fromLongToEntity(dto.getPlotId()),
                plotCoordinatesDto.getLatitude(),
                plotCoordinatesDto.getLongitude())));
        return plotCoordinates;
    }


    public Plot fromLongToEntity(Long id) {
        return plotService.getPlot(id);
    }
}
