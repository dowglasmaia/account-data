package com.maia.accountdata.entrypoint.controller.mapper;

import com.maia.accountdata.core.domain.Customer;
import com.maia.accountdata.entrypoint.controller.request.CustomerRequest;
import com.maia.accountdata.entrypoint.controller.response.CustomerResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerRequestMapper {

    Customer toCustomer(CustomerRequest request);
    CustomerResponse toCustomerResponse(Customer response);
}
