package com.sistemasactivos.user.interfaces;

import com.sistemasactivos.user.model.Base;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;

public interface BaseController <E extends Base, ID extends Serializable> {
    public ResponseEntity<?> getAllRecords() throws Exception;
    public ResponseEntity<?> getRecordBy(Pageable pageable, @RequestParam(name = "sort", required = false) String sort) throws Exception;
    public ResponseEntity<?> getRecordById(@PathVariable ID id) throws Exception;
    public ResponseEntity<?> saveRecord(@Valid @RequestBody E entity, BindingResult result) throws Exception;;
    public ResponseEntity<?> updateRecord(@PathVariable ID id,@Valid @RequestBody E entity, BindingResult result) throws Exception;
    public ResponseEntity<?> deleteRecord(@PathVariable ID id) throws Exception;
}