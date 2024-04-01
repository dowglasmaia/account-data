package com.maia.accountdata.dataprovider.repository.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
public class AddressEntity {
    private String street;
    private String number;
    private String city;
    private String state;
    private String neighborhood;
    @Indexed
    private String zip;
}
