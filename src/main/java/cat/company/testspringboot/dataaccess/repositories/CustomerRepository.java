package cat.company.testspringboot.dataaccess.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import cat.company.testspringboot.dataaccess.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
    List<Customer> findByLastName(String lastName);
    Customer findById(long id);
}
