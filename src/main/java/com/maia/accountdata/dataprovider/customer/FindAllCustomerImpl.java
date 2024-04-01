package com.maia.accountdata.dataprovider.customer;

import com.maia.accountdata.core.dataprovider.customer.FindAllCustomer;
import com.maia.accountdata.core.domain.Customer;
import com.maia.accountdata.dataprovider.repository.CustomerRepository;
import com.maia.accountdata.dataprovider.repository.mapper.CustomerMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Log4j2
@Service
public class FindAllCustomerImpl implements FindAllCustomer {
    @Autowired
    private CustomerRepository repository;
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Set<Customer> find() {
        try {
            return customerMapper.toCustomers(repository.findAllCustomer());
        } catch (Exception e) {
            log.error("Failed to List Customer. {}", e);
            throw new RuntimeException("");
        }
    }
}

