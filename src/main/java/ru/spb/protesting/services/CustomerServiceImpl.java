package ru.spb.protesting.services;

import ru.spb.protesting.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spb.protesting.repositories.CustomerRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl{

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> finaAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Long id) {
        return customerRepository.getOne(id);
    }

    public Long save(Customer newCustomer) {
        return customerRepository.save(newCustomer).getId();
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    public Long update(Long id, Customer updatedCustomer) {
        updatedCustomer.setId(id);
        return customerRepository.save(updatedCustomer).getId();
    }

}
