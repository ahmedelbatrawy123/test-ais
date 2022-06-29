package com.batrawy.ais.dto.request;

import com.batrawy.ais.dto.PlotCoordinatesDto;
import lombok.Data;

import java.util.List;

@Data
public class PlotCoordinatesRequestDto {

    List<PlotCoordinatesDto> plotCoordinatesList;
    private Long plotId;

}
