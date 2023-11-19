package co.udea.ssmu.api.controller;

import co.udea.ssmu.api.model.dto.Conductor;
import co.udea.ssmu.api.model.dto.Pqrs;

import co.udea.ssmu.api.service.conductor.IConductorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/conductor")
@CrossOrigin("localhost:3000")
public class ConductorController {


    @Autowired
    IConductorService conductorService;

    // Método para actualizar el estado de un conductor
    @Operation(summary = "Actualizar estado conductor ",
    responses={
            // Cambiar el schema
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Pqrs.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "La petición se ha procesado correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta"),
            @ApiResponse(responseCode = "400", description = "Error en la información")
    })
    @PutMapping(path = "/{id}/{conductorState}")
    public ResponseEntity<Conductor> updateConductorState(@PathVariable("id") Integer id, @PathVariable("conductorState") Boolean conductorState){


        return new ResponseEntity<>(conductorService.estadoConductor(id,conductorState), HttpStatus.OK);
    }

}
