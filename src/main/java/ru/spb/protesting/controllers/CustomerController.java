package ru.spb.protesting.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.spb.protesting.entity.Customer;
import ru.spb.protesting.services.CustomerServiceImpl;

import java.util.Hashtable;
import java.util.List;

@RestController
@RequestMapping("/customers")
@Tag(name = "Customers API", description = "Methods to work with customers")
public class CustomerController {

    private final CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl service) {
        this.customerService = service;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get customer by id")
    public Customer getOneById(
            @Parameter(name = "id", description = "Unique number identifier")
            @PathVariable("id") Long id) {
        return customerService.findById(id);
    }

    @GetMapping
    @Operation(summary = "Get all customers")
    public List<Customer> getAll() {
        return customerService.finaAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create new customer")
    public ResponseEntity<Long> newCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.save(customer));
    }

    //TODO не смог приделать ResponseEntity, почему-то ничего не выдает если его использовать

    @PutMapping("/{id}")
    @Operation(summary = "Edit customer by id")
    public String editCustomer(
            @Parameter(name = "id", description = "Unique number identifier")
            @PathVariable("id") Long id,
            @RequestBody Customer customer) {
        if (customerService.findById(id) == null) {
            return "Customer with this id does not exist";
        }
        customer.setId(id);
        long savedId = customerService.save(customer);
        return String.valueOf(savedId);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete customer by id")
    public void deleteCustomer(@PathVariable("id") Long id) {
        customerService.delete(id);
    }

}
