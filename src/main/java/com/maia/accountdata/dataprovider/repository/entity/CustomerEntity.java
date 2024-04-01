package com.maia.accountdata.dataprovider.repository.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "customer")
public class CustomerEntity {

    @Id
    private String id;
    private String name;
    @Indexed
    private String cpf;
    private AddressEntity address;
    private Boolean isValidCpf;

}
