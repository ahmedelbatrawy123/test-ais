package com.batrawy.ais.mapper;


import com.batrawy.ais.dto.PlotDto;
import com.batrawy.ais.model.Plot;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PlotStatusMapper.class})
public interface PlotMapper {
    Plot fromDtoToModel(PlotDto dto);
    PlotDto fromModelToDto(Plot plot);
    List<PlotDto> fromModelToDtoAsList(List<Plot> plotList);
}
