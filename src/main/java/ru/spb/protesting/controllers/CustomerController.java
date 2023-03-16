package ru.spb.protesting.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.spb.protesting.entity.Customer;
import ru.spb.protesting.services.CustomerServiceImpl;

import java.util.Hashtable;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl service) {
        this.customerService = service;
    }

    @GetMapping("/{id}")
    public Customer getOneById(@PathVariable("id") Long id) {
        return customerService.findById(id);
    }

    @GetMapping
    public List<Customer> getAll() {
        return customerService.finaAll();
    }

    //TODO надо понять как тут задать Content-Type application/json, потому что без этого хэдера не сохраняет,
    // Аленка говорит что они руками настройку выбирают и им пофуй

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> newCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.save(customer));
    }

    //TODO не смог приделать ResponseEntity, почему-то ничего не выдает если его использовать

    @PutMapping("/{id}")
    public String editCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
        if (customerService.findById(id) == null) {
            return "Customer with this id does not exist";
        }
        customer.setId(id);
        long savedId = customerService.save(customer);
        return String.valueOf(savedId);
    }

    //TODO не удаляет, кидает 404. Чо за гуано?

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Long id) {
        customerService.delete(id);
    }

}
