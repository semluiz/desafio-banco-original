package com.spring.apibancooriginal.controller;

import com.spring.apibancooriginal.model.Cliente;
import com.spring.apibancooriginal.repository.ClienteRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RequestMapping(value = "/api")
@RestController
@CrossOrigin(origins = "*")
@Api(value = "API Rest - Banco Original")
public class ClienteController {
    @Autowired
    ClienteRepository repository;

    @GetMapping("/cliente")
    @ApiOperation(value = "retorna uma lista de clientes")
    public List<Cliente> listClientes() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

    @GetMapping("/cliente/{id}")
    @ApiOperation(value = "retorna um cliente específico")
    public Cliente listClientById(@PathVariable(value = "id") Integer id) {
        try {
            return repository.findById(id).get();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @ApiOperation(value = "remove um cliente")
    @DeleteMapping("/cliente/{id}")
    public void deleteCliente(@PathVariable(value = "id") Integer id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/salvar")
    @ApiOperation(value = "Criar um cliente")
    public Cliente saveCliente(@RequestBody Cliente cliente) {
        try {
            return repository.save(cliente);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @PutMapping("/cliente/{id}")
    @ApiOperation(value = "salva os dados de um novo cliente")
    public Cliente updateCliente(@PathVariable("id") Integer id, Cliente cliente) {
        try {
            return repository.save(cliente);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
