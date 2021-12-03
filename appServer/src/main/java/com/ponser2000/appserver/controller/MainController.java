package com.ponser2000.appserver.controller;

import com.ponser2000.appserver.service.ContractDatabaseSearch;
import com.ponser2000.appserver.to.ContractTo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final ContractDatabaseSearch contractDatabaseSearch;

    @GetMapping(value = "/appserver/all/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ContractTo>> readAllContracts() {
        List<ContractTo> result = contractDatabaseSearch.getAll();
        return ResponseEntity.ok().body(result);
    }
}
