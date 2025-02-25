package com.rodrigo.panelAdmin.services;

import com.rodrigo.panelAdmin.entities.Customer;
import com.rodrigo.panelAdmin.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomer(Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return customer.get();
        }
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> list = new ArrayList<>();

        Iterable<Customer> customers = customerRepository.findAll();
        for (Customer customer:customers) {
            list.add(customer);
        }
        return list;
    }

    @Override
    public void removeCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Integer id, Customer updateCustomer) {
        updateCustomer.setId(id);
        customerRepository.save(updateCustomer);
    }

    @Override
    public List<Customer> searchCustomer(String email, String address) {
        return customerRepository.findByEmailOrAddress(email, address);
    }
}
