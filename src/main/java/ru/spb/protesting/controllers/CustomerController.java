package ru.spb.protesting.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.spb.protesting.entity.Customer;
import ru.spb.protesting.services.CustomerServiceImpl;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl service) {
        this.customerService = service;
    }

    @ResponseBody //не проставил ее и была ошибка с отстутсвием темплейта
    @GetMapping("/{id}")
    public Customer personJson(@PathVariable("id") long id) {
        return customerService.findById(id);
    }

    @ResponseBody
    @GetMapping
    public List<Customer> allPeopleJson() {
        return customerService.finaAll();
    }

    //TODO надо понять как тут задать Content-Type application/json, потому что без этого хэдера не сохраняет,
    // Аленка говорит что они руками настройку выбирают и им пофуй

    @ResponseBody
    @PostMapping(value = "/new",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public long newPersonJson(@RequestBody Customer customer) throws InstanceAlreadyExistsException {
        return customerService.save(customer);
    }

    //TODO не смог приделать ResponseEntity, почему-то ничего не выдает если его использовать

    @ResponseBody
    @PutMapping("/{id}")
    public String editJson(@PathVariable("id") long id, @RequestBody Customer customer) {
        if (customerService.findById(id) == null) {
            return "Customer with this id does not exist";
        }
        customer.setId(id);
        long savedId = customerService.save(customer);
        return String.valueOf(savedId);
    }

    //TODO кидает 500ю ошибку, но при этом удаляет. Чо за гуано?
    @DeleteMapping("/{id}")
    public void jsonDelete(@PathVariable("id") long id) {
        customerService.delete(id);
    }
}
