package com.maia.accountdata.entrypoint.mapper;

import com.maia.accountdata.core.domain.Customer;
import com.maia.accountdata.entrypoint.request.CustomerRequest;
import com.maia.accountdata.entrypoint.response.CustomerResponse;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface CustomerRequestMapper {

    Customer toCustomer(CustomerRequest request);
    CustomerResponse toCustomerResponse(Customer Customer);
    List<CustomerResponse> toCustomersResponse(Set<Customer> Customers);
}
