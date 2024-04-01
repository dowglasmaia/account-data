package com.maia.accountdata.dataprovider.customer;

import com.maia.accountdata.core.dataprovider.customer.DeleteCustomer;
import com.maia.accountdata.dataprovider.repository.CustomerRepository;
import com.maia.accountdata.dataprovider.repository.mapper.CustomerMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class DeleteCustomerImpl implements DeleteCustomer {
    @Autowired
    private CustomerRepository repository;
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public void delete(String id) {
        var customerEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Customer not found")
        );

        try {
            repository.delete(customerEntity);
        } catch (Exception e) {
            log.error("Failed to delete Customer. {}", e);
            throw new RuntimeException("Failed to delete Customer");
        }
    }

}

