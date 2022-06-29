package com.batrawy.ais.controller;

import com.batrawy.ais.dto.PlotCoordinatesDto;
import com.batrawy.ais.dto.request.PlotCoordinatesRequestDto;
import com.batrawy.ais.service.CoordinatesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "coordinates-controller")
@AllArgsConstructor
@RestController
@RequestMapping("coordinates")
public class CoordinatesController {

    private final CoordinatesService coordinatesService;

    @ApiOperation(value = "Get list of plot coordinates.")
    @ApiResponses(value = {
            @ApiResponse(response = List.class, code = 200, message = "OK")})
    @GetMapping("/{plotId}")
    public ResponseEntity<List<PlotCoordinatesDto>> getPlotCoordinates(@PathVariable Long plotId) {
        return new ResponseEntity<>(coordinatesService.getPlotCoordinates(plotId), HttpStatus.OK);
    }

    @ApiOperation(value = "Assign Coordinates to a plot, removes existent before coordinates.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created")})
    @PostMapping("")
    public ResponseEntity<Void> assignPlotCoordinates(@RequestBody PlotCoordinatesRequestDto coordinates) {
        this.coordinatesService.assignPlotCoordinates(coordinates);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
