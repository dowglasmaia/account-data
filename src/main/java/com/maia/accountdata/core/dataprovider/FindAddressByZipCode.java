package com.maia.accountdata.core.dataprovider;

import com.maia.accountdata.core.domain.Address;

import java.util.Optional;

public interface FindAddressByZipCode {

    Optional<Address> find (final String zipCode);
}
