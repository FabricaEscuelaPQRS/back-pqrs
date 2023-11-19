package co.udea.ssmu.api.controller;


import co.udea.ssmu.api.model.dto.Pqrs;
import co.udea.ssmu.api.model.dto.Usuario;
import co.udea.ssmu.api.service.user.IUserService;
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
@RequestMapping("/usuario")
@CrossOrigin("localhost:3000")
public class UsuarioController {

    @Autowired
    IUserService userService;

    // Método para actualizar el estado de un usuario
    @Operation(summary = "Actualizar estado usuario ",
    responses={
            // Cambiar el schema
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Pqrs.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "La petición se ha procesado correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta"),
            @ApiResponse(responseCode = "400", description = "Error en la información")
    })
    @PutMapping(path = "/{id}/{userState}")
    public ResponseEntity<Usuario> updateUserState(@PathVariable("id") Integer id, @PathVariable("userState") Boolean userState){


        return new ResponseEntity<>(userService.estadoUser(id,userState), HttpStatus.OK);
    }




}
