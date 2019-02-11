package com.development.test.developmenttest.controller;

import com.development.test.developmenttest.domain.Customer;
import com.development.test.developmenttest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("customers")
@CrossOrigin("*")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void save(@RequestBody Customer customer){
        this.customerService.save(null, customer);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void edit(@PathVariable("id") String id,
            @RequestBody Customer customer) {
        this.customerService.save(id, customer);
    }

    @GetMapping()
    public ResponseEntity<?> list(){
        return Optional.ofNullable(this.customerService.list()).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") String id){
        return this.customerService.get(id).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
