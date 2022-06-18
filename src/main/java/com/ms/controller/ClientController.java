package com.ms.controller;
import com.ms.entities.*;
import com.ms.services.ClientService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/client/addclient")
    public ResponseEntity<?> save(@RequestBody Client client ){

        client =  clientService.save(client);
        return ResponseEntity.status(HttpStatus.FOUND).body(client);

    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Client client){

        client = clientService.save(client);
        return ResponseEntity.status(HttpStatus.FOUND).body(client);

    }
    
    @GetMapping("/client")
    public ResponseEntity<?> getAll(){
        List<Client> clientList = clientService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(clientList);
    }
    
    @DeleteMapping("/client/{id}")
    public Object delete(@PathVariable Long id)
    {
        clientService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }
}