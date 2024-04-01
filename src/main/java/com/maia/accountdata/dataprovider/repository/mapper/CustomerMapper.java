package com.maia.accountdata.dataprovider.repository.mapper;

import com.maia.accountdata.core.domain.Customer;
import com.maia.accountdata.dataprovider.repository.entity.CustomerEntity;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity entity);

    Set<Customer> toCustomers(Set<CustomerEntity> entities);

}
