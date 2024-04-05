package com.maia.accountdata.entrypoint.cosumer.mapper;

import com.maia.accountdata.core.domain.Customer;
import com.maia.accountdata.entrypoint.cosumer.message.CustomerMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

    Customer toCustomer(CustomerMessage customerMessage);


}
