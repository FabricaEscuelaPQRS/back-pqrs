package co.udea.ssmu.api.controller;


import co.udea.ssmu.api.model.entities.PqrsE;
import co.udea.ssmu.api.model.entities.PqrsMessageE;
import co.udea.ssmu.api.model.repositories.PqrsMessageRepository;
import co.udea.ssmu.api.model.repositories.PqrsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class pqrs {
    @Autowired
    private PqrsMessageRepository pqrsRepository;

    @GetMapping(path = "/")
    public String pqrs() {
        return "PQRS";
    }

    @GetMapping(path = "/testDataBase")
    public ResponseEntity<ArrayList<PqrsMessageE>> test() {
        ArrayList<PqrsMessageE> pqrs = pqrsRepository.findByPqrsId(2);
        return ResponseEntity.status(200).body(pqrs);
    }
}
