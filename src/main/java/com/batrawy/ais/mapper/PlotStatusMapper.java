package com.batrawy.ais.mapper;


import com.batrawy.ais.dto.PlotStatusDto;
import com.batrawy.ais.model.PlotStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public  interface PlotStatusMapper {

    PlotStatus fromDtoToModel(PlotStatusDto dto);
}
