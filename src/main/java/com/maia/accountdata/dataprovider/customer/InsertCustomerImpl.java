package com.maia.accountdata.dataprovider.customer;

import com.maia.accountdata.core.dataprovider.customer.InsertCustomer;
import com.maia.accountdata.core.domain.Customer;
import com.maia.accountdata.dataprovider.repository.CustomerRepository;
import com.maia.accountdata.dataprovider.repository.mapper.CustomerMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class InsertCustomerImpl implements InsertCustomer {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer insert(Customer customer) {
        var customerEntity = customerMapper.toCustomerEntity(customer);
        try {
            return customerMapper.toCustomer(customerRepository.save(customerEntity));
        } catch (Exception e) {
            log.error("Failed to save Customer. {}, Error: {}", customer, e);
            throw new RuntimeException("Failed to save Customer");
        }
    }
}

