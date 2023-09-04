package cat.company.testspringboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.company.testspringboot.dataaccess.model.Customer;
import cat.company.testspringboot.dataaccess.repositories.CustomerRepository;

@RestController
public class HelloController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping("/")
    public List<Customer> index(){
        return repository.findAll();
    }

    @PostMapping("/customer")
    public Customer createCustomer(Customer customer){
        return repository.save(customer);
    }
}