package co.udea.ssmu.api.controller;


import co.udea.ssmu.api.model.dto.Archive;
import co.udea.ssmu.api.model.dto.Pqrs;
import co.udea.ssmu.api.model.dto.User;
import co.udea.ssmu.api.model.entity.ArchiveE;
import co.udea.ssmu.api.model.entity.PqrsE;
import co.udea.ssmu.api.model.entity.PqrsMessageE;
import co.udea.ssmu.api.model.entity.SsmuUserE;
import co.udea.ssmu.api.model.mapper.ArchiveMapper;
import co.udea.ssmu.api.model.mapper.PqrsMapper;
import co.udea.ssmu.api.model.mapper.UserMapper;
import co.udea.ssmu.api.model.repository.PqrsMessageRepository;
import co.udea.ssmu.api.model.repository.PqrsRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Tag(name = "Drivers", description = "Gestión de conductores")
@RestController
public class pqrs {
    @Autowired
    private PqrsRepository pqrsRepository;

    @Autowired
    private PqrsMapper pqrsMapper;

    @GetMapping(path = "/")
    public String pqrs() {
        return "this is a api for module pqrs";
    }


    @Operation(summary = "Guardar una pqrs")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Pqrs.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "La petición se ha procesado correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")})
    @PostMapping(path = "/savePqrs")
    public ResponseEntity<Pqrs> savePqrs(@RequestBody Pqrs pqrs){

        pqrs.setId(null); //debe ser nulo

        PqrsE pqrsE = pqrsMapper.toEntity(pqrs); // convertir el dto a entidad de base de datos

        pqrsE = pqrsRepository.save(pqrsE); // guardar la entidad en la base de datos

        Pqrs pqrsResponse = pqrsMapper.toDto(pqrsE); // convertir la entidad a dto

        return ResponseEntity.ok().body(pqrsResponse);
    }



}
