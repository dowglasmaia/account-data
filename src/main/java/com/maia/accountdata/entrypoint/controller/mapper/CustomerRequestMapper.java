package com.maia.accountdata.entrypoint.controller.mapper;

import com.maia.accountdata.core.domain.Customer;
import com.maia.accountdata.entrypoint.controller.request.CustomerRequest;
import com.maia.accountdata.entrypoint.controller.response.CustomerResponse;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface CustomerRequestMapper {

    Customer toCustomer(CustomerRequest request);
    CustomerResponse toCustomerResponse(Customer Customer);
    List<CustomerResponse> toCustomersResponse(Set<Customer> Customers);
}
