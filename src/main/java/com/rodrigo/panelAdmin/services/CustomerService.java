package com.rodrigo.panelAdmin.services;

import com.rodrigo.panelAdmin.entities.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomer(Integer id);
    List<Customer> getAllCustomers();
    void removeCustomer(Integer id);
    void addCustomer(Customer customer);
    void updateCustomer(Integer id, Customer updateCustomer);
    List<Customer> searchCustomer(String email, String address);
}
