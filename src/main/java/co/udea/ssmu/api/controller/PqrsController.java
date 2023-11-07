package co.udea.ssmu.api.controller;


import co.udea.ssmu.api.model.dto.Pqrs;
import co.udea.ssmu.api.model.entity.Conductor;
import co.udea.ssmu.api.model.entity.PqrsEntity;

import co.udea.ssmu.api.service.pqrs.IPqrsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Tag(name = "Pqrs", description = "Recursos de PQRS")

@RestController
@RequestMapping("/pqrs")
@CrossOrigin("*")
public class PqrsController {

    @Autowired
    IPqrsService pqrsService;







    @Operation(summary = "Guardar una pqrs")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Pqrs.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "La petición se ha procesado correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta"),
            @ApiResponse(responseCode = "400", description = "Error en la información")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public ResponseEntity<Pqrs> createPqrs(@RequestBody Pqrs pqrs){

       Pqrs pqrsCreated= pqrsService.createPqrs(pqrs);

       if (pqrsCreated == null){
           return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
       }

        return new ResponseEntity<>(pqrsCreated,HttpStatus.CREATED);
    }



    @Operation(summary = "Borrar una pqrs")
    @ApiResponses({
            // Cambiar el schema
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Pqrs.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "La petición se ha procesado correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta"),
            @ApiResponse(responseCode = "400", description = "Error en la información")
    })
    @DeleteMapping("{id}")
    public ResponseEntity<Pqrs> deletePqrs(@PathVariable("id")  Integer id){

        Pqrs pqrsDeleted= pqrsService.deletePqrs(id);

        if (pqrsDeleted == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(pqrsDeleted,HttpStatus.OK);
    }



    @Operation(summary = "Listar pqrs")
    @ApiResponses({
            // Cambiar el schema
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Pqrs.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "La petición se ha procesado correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta"),
            @ApiResponse(responseCode = "400", description = "Error en la información")
    })
    @GetMapping()
    public ResponseEntity<Iterable<PqrsEntity>> listPqrs(){

        return new ResponseEntity<>(pqrsService.listPqrs(),HttpStatus.OK);
    }



    @Operation(summary = "Obtener pqrs por id")
    @ApiResponses({
            // Cambiar el schema
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Pqrs.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "La petición se ha procesado correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta"),
            @ApiResponse(responseCode = "400", description = "Error en la información")
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<Pqrs> getPqrsById(@PathVariable("id")  Integer id){

        Pqrs pqrsObtained= pqrsService.getPqrsById(id);

        if (pqrsObtained == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(pqrsObtained,HttpStatus.OK);
    }




    @Operation(summary = "Actualizar estado pqrs ")
    @ApiResponses({
            // Cambiar el schema
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Pqrs.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "La petición se ha procesado correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta"),
            @ApiResponse(responseCode = "400", description = "Error en la información")
    })
    @PutMapping(path = "/{id}/{pqrsState}")
    public ResponseEntity<Pqrs> updatePqrsState(@PathVariable("id") Integer id,@PathVariable("pqrsState") String pqrsState){


        return new ResponseEntity<>(pqrsService.updatePqrs(pqrsState,id),HttpStatus.OK);
    }



    @Operation(summary = "Listar pqrs por usuario")
    @ApiResponses({
            // Cambiar el schema
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Pqrs.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "La petición se ha procesado correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta"),
            @ApiResponse(responseCode = "400", description = "Error en la información")
    })
    @GetMapping(path="/user/{id}")
    public ResponseEntity<Iterable<PqrsEntity>> listPqrsByUser(@PathVariable("id") Integer id){

        return new ResponseEntity<>(pqrsService.getPqrsByUsuario(id),HttpStatus.OK);
    }


    @Operation(summary = "Listar pqrs por conductor")
    @ApiResponses({
            // Cambiar el schema
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Pqrs.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "La petición se ha procesado correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta"),
            @ApiResponse(responseCode = "400", description = "Error en la información")
    })
    @GetMapping(path="/conductor/{id}")
    public ResponseEntity<Iterable<PqrsEntity>> listPqrsByConductor(@PathVariable("id") Integer id){

        return new ResponseEntity<>(pqrsService.getPqrsByConductor(id),HttpStatus.OK);
    }

}
