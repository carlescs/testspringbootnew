package cat.company.testspringboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import cat.company.testspringboot.dataaccess.model.Customer;
import cat.company.testspringboot.dataaccess.repositories.CustomerRepository;

@RestController
public class HelloController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping("/")
    public List<Customer> index() {
        return repository.findAll();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable("id") Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
    }

    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody Customer customer) {
        return repository.save(customer);
    }
}