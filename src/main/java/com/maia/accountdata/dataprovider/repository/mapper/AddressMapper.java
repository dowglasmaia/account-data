package com.maia.accountdata.dataprovider.repository.mapper;

import com.maia.accountdata.core.domain.Address;
import com.maia.accountdata.dataprovider.repository.entity.AddressEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressEntity toAddressEntity(Address address);
}
