package com.sistemasactivos.user.controller;


import com.sistemasactivos.user.interfaces.BaseController;
import com.sistemasactivos.user.model.Base;
import com.sistemasactivos.user.service.BaseServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

public abstract class BaseControllerImpl < E extends Base, S extends BaseServiceImpl<E,Integer>> implements BaseController<E,Integer> {
    @Autowired
    protected S service;

    @Operation(summary = "Obtiene todos los Costumers", description = "Devuelve todos los Costumers")
    @Override
    @GetMapping(path = {""})
    public ResponseEntity<?> getAllRecords() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Operation(summary = "Obtiene todos los Costumers con un sort, paginados", description = "Devuelve todos los Costumers con un sort, paginados")
    @Override
    @GetMapping(path = {"/page"})
    public ResponseEntity<?> getRecordBy(Pageable pageable, @RequestParam(name = "sort", required = false) String sort) {
        try {
            if (sort != null) {
                pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(sort));
            }
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Operation(summary = "Obtiene uno de los Costumers", description = "Devuelve uno de los Costumers")
    @Override
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> getRecordById(@PathVariable Integer id) throws Exception {
        // valida la existencia del id
        if (!service.existId(id))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El registro con id " + id + " no existe");

        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Operation(summary = "Crea un Costumer", description = "Crea un Costumer")
    @Override
    @PostMapping(path = {""})
    public ResponseEntity<?> saveRecord(@Valid @RequestBody E entity, BindingResult result) {
        // valida los campos de la entidad
        if (result.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.getFieldError().getDefaultMessage());

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Operation(summary = "Obtiene uno de los Costumers", description = "Devuelve uno de los Costumers")
    @Override
    @PutMapping(path = {"/{id}"})
    public ResponseEntity<?> updateRecord(@PathVariable Integer id,@Valid @RequestBody E entity, BindingResult result) throws Exception {
        // valida la existencia del id
        if (!service.existId(id))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El registro con id " + id + " no existe");

        // valida los campos de la entidad
        if (result.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.getFieldError().getDefaultMessage());

        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.update(id, entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Operation(summary = "Elimina un Costumer", description = "Elimina un Costumer")
    @Override
    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> deleteRecord(@PathVariable Integer id) throws Exception {
        // valida la existencia del id
        if (!service.existId(id))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El registro con id " + id + " no existe");

        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}

