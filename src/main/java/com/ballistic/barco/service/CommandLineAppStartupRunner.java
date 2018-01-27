package com.ballistic.barco.service;

import com.ballistic.barco.domain.users.Customer;
import com.ballistic.barco.domain.users.Employee;
import com.ballistic.barco.domain.users.Shipper;
import com.ballistic.barco.domain.users.Supplier;
import com.ballistic.barco.repository.CustomerRepository;
import com.ballistic.barco.repository.EmployeeRepository;
import com.ballistic.barco.repository.ShipperRepository;
import com.ballistic.barco.repository.SupplierRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by Nabeel on 1/12/2018.
 */
@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);

     @Autowired
     private PasswordEncoder passwordEncoder;
     @Autowired
     private CustomerRepository customerRepository;
     @Autowired
     private EmployeeRepository employeeRepository;
     @Autowired
     private ShipperRepository shipperRepository;
     @Autowired
     private SupplierRepository supplierRepository;

    // play ground for jdbc.... hint password:123
    @Override
    public void run(String...args) throws Exception {
       // doProcess();
    }

    private void createCustomer() {
        Customer customer = new Customer();
        customer.setUsername("nabeel.amd93");
        customer.setEmail("nabeel.amd93@gmail.com");
        customer.setPassword(passwordEncoder.encode("nabeel.amd93"));
        customerRepository.save(customer);
    }

    private void createEmployee() {
        Employee employee = new Employee();
        employee.setEmail("abubaker93@gmail.com");
        employee.setUsername("abubaker93");
        employee.setPassword(passwordEncoder.encode("abubaker93"));
        employeeRepository.save(employee);
    }

    private void createShipper() {
        Shipper shipper = new Shipper();
        shipper.setEmail("shipper93@gmail.com");
        shipper.setUsername("shipper93");
        shipper.setPassword(passwordEncoder.encode("shipper93"));
        shipperRepository.save(shipper);
    }

    private void createSupplier() {
        Supplier supplier = new Supplier();
        supplier.setEmail("supplier93@gmail.com");
        supplier.setUsername("supplier93");
        supplier.setPassword(passwordEncoder.encode("supplier93"));
        supplierRepository.save(supplier);
    }

    private void doProcess() {
        createCustomer();
        createEmployee();
        createShipper();
        createSupplier();
    }
}