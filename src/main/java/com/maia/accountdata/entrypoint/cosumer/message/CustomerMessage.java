package com.maia.accountdata.entrypoint.cosumer.message;

import com.maia.accountdata.core.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerMessage {
    private String id;
    private String name;
    private String cpf;
    private Address address;
    private Boolean isValidCpf;
}
