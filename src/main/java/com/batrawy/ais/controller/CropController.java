package com.batrawy.ais.controller;

import com.batrawy.ais.model.Corp;
import com.batrawy.ais.service.CropService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "coordinates-controller")
@AllArgsConstructor
@RestController
@RequestMapping("crop")
public class CropController {

    private final CropService cropService;

    @ApiOperation(value = "Assign Coordinates to a plot, removes existent before coordinates.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created")})
    @PostMapping("")
    public ResponseEntity<Void> assignPlotCoordinates(@RequestBody Corp corp) {
        cropService.addCrop(corp);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
