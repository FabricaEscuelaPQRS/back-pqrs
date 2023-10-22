package co.udea.ssmu.api.controller;


import co.udea.ssmu.api.model.dto.Pqrs;
import co.udea.ssmu.api.model.entity.PqrsE;

import co.udea.ssmu.api.model.mapper.PqrsMapper;
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

@Tag(name = "Pqrs", description = "Recursos de PQRS")

@RestController
@RequestMapping("/pqrs")
public class PqrsController {

    @Autowired
    IPqrsService pqrsService;



    @GetMapping(path = "/index")
    public String pqrs() {
        return "this is a api for module pqrs";
    }


    @Operation(summary = "Guardar una pqrs")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Pqrs.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "La petición se ha procesado correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta"),
            @ApiResponse(responseCode = "400", description = "Error en la información")
    })
    @PostMapping()
    public ResponseEntity<Pqrs> createPqrs(@RequestBody Pqrs pqrs){

       Pqrs pqrsCreated= pqrsService.createPqrs(pqrs);

       if (pqrsCreated == null){
           return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
       }

        return new ResponseEntity<>(pqrsCreated,HttpStatus.OK);
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
    @DeleteMapping()
    public ResponseEntity<Pqrs> deletePqrs(@RequestBody Integer id){

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
    public ResponseEntity<Iterable<PqrsE>> listPqrs(){

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
    @GetMapping(path = "/id")
    public ResponseEntity<Pqrs> getPqrsById(@RequestBody Integer id){

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
    @PutMapping()
    public ResponseEntity<Pqrs> getPqrsById(@RequestBody Integer id,@RequestBody String pqrsState){


        return new ResponseEntity<>(pqrsService.updatePqrs(pqrsState,id),HttpStatus.OK);
    }


}
