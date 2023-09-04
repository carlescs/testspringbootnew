package cat.company.testspringboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import cat.company.testspringboot.dataaccess.model.Customer;
import cat.company.testspringboot.dataaccess.repositories.CustomerRepository;

@RestController
@RequestMapping("/api/customers")
public class HelloController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping("")
    public List<Customer> index() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Customer getCustomer(@PathVariable("id") Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
    }

    @PostMapping("")
    public Customer createCustomer(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }

    @PutMapping("{id}")
    public Customer updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
        Customer customerToUpdate = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
        customerToUpdate.setFirstName(customer.getFirstName());
        customerToUpdate.setLastName(customer.getLastName());
        return repository.save(customerToUpdate);
    }
}