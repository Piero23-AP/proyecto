package com.example.CrudSQL.controller;

import com.example.CrudSQL.model.Card;
import com.example.CrudSQL.model.ServiceResponse;
import com.example.CrudSQL.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/card")
@CrossOrigin
public class CardController {

    @Autowired
    private ICardService iCardService;

    @GetMapping("/listar")
    public ResponseEntity<List<Card>> list(){
        var result = iCardService.findAll();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/guardar")
    public ResponseEntity<ServiceResponse> save(@RequestBody Card card){

        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iCardService.save(card);

        if (result == 1){
            serviceResponse.setMessage("success");
        }
        return new ResponseEntity<>(serviceResponse,HttpStatus.OK);
    }

    @PostMapping("/actualizar")
    public ResponseEntity<ServiceResponse> update(@RequestBody Card card){

        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iCardService.update(card);

        if (result == 1){
            serviceResponse.setMessage("success");
        }
        return new ResponseEntity<>(serviceResponse,HttpStatus.OK);
    }

    @GetMapping("/eliminar/{id}")
    public ResponseEntity<ServiceResponse> update(@RequestBody int id){

        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iCardService.deleteById(id);
        if (result == 1){
            serviceResponse.setMessage("remove");
        }
        return new ResponseEntity<>(serviceResponse,HttpStatus.OK);
    }
}