package com.maia.accountdata.dataprovider.customer;

import com.maia.accountdata.core.dataprovider.customer.UpdateCustomer;
import com.maia.accountdata.core.domain.Customer;
import com.maia.accountdata.core.exception.NotFoundException;
import com.maia.accountdata.dataprovider.repository.CustomerRepository;
import com.maia.accountdata.dataprovider.repository.entity.CustomerEntity;
import com.maia.accountdata.dataprovider.repository.mapper.AddressMapper;
import com.maia.accountdata.dataprovider.repository.mapper.CustomerMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class UpdateCustomerImpl implements UpdateCustomer {
    @Autowired
    private CustomerRepository repository;
    @Autowired
    private CustomerMapper mapper;

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Customer update(Customer customer, String id) {
        var customerEntity = repository.findById(id).orElseThrow(
                () -> new NotFoundException("Customer not found")
        );

        try {
            processEntityUpdate(customerEntity, customer);

            var customerEntitySaved = repository.save(processEntityUpdate(customerEntity, customer));

            return mapper.toCustomer(customerEntitySaved);
        } catch (Exception e) {
            log.error("Failed to Update Customer. {}: Error: {}", customer, e);
            throw new RuntimeException("Failed to Update Customer");
        }
    }

    private CustomerEntity processEntityUpdate(CustomerEntity entity, Customer customer) {
        entity.setName(customer.getName());
        entity.setAddress(addressMapper.toAddressEntity(customer.getAddress()));
        entity.setCpf(customer.getCpf());
        entity.setIsValidCpf(customer.getValidCpf());

        return entity;
    }
}

