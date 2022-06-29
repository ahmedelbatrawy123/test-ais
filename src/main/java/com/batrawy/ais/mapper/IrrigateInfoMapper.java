package com.batrawy.ais.mapper;


import com.batrawy.ais.dto.request.IrrigateInfoDto;
import com.batrawy.ais.model.Corp;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface IrrigateInfoMapper {

    IrrigateInfoDto fromCropToIrrigateInfo(Corp corp);
}
