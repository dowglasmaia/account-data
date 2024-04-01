package com.maia.accountdata.dataprovider.client.mapper;

import com.maia.accountdata.core.domain.Address;
import com.maia.accountdata.dataprovider.client.response.AddressResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
