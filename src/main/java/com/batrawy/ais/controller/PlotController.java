package com.batrawy.ais.controller;

import com.batrawy.ais.dto.PlotDto;
import com.batrawy.ais.service.PlotService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "plot-controller")
@AllArgsConstructor
@RestController
@RequestMapping("plot")
public class PlotController {

    private final PlotService plotService;

    @ApiOperation(value = "Get list of all existing plots.")
    @ApiResponses(value = {
            @ApiResponse(response = List.class, code = 200, message = "OK")})
    @GetMapping("")
    public ResponseEntity<List<PlotDto>> getAllPlots() {
        return new ResponseEntity<>(plotService.getAllPlots(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get existing plot by plot id.")
    @ApiResponses(value = {
            @ApiResponse(response = PlotDto.class, code = 200, message = "OK")})
    @GetMapping("/{id}")
    public ResponseEntity<PlotDto> getPlotInfo(@PathVariable long id) {
        return new ResponseEntity<>(plotService.getPlotInfo(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Creat new plot.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created")})
    @PostMapping("")
    public ResponseEntity<Void> createPlot(@RequestBody PlotDto plotDto) {
        this.plotService.savePlot(plotDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update existing plot.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK")})
    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePlot(@PathVariable long id, @RequestBody PlotDto plotDto) {
        plotDto.setId(id);
        this.plotService.savePlot(plotDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a plot.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlot(@PathVariable long id) {
        plotService.deletePlot(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
