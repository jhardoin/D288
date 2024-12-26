package com.example.d288_backend.BootStrapData;

import com.example.d288_backend.dao.CustomerRepository;
import com.example.d288_backend.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public BootStrapData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (customerRepository.count() <= 1) {

            Customer customer1 = new Customer("Jim", "Jones", "123 Main St", "11111", "(111)111-1111");
            Customer customer2 = new Customer("John", "Smith", "456 Main St", "22222", "(222)222-2222");
            Customer customer3 = new Customer("Steve", "Brown", "789 Main St", "33333", "(333)333-3333");
            Customer customer4 = new Customer("Bob", "Jones", "123 First St", "44444", "(444)444-4444");
            Customer customer5 = new Customer("Dave", "Smith", "123 Second St", "55555", "(555)555-5555");

            customerRepository.save(customer1);
            customerRepository.save(customer2);
            customerRepository.save(customer3);
            customerRepository.save(customer4);
            customerRepository.save(customer5);

            System.out.println("Sample customers added");
        } else {
            System.out.println("Sample customers already exist.");
        }
    }
}
