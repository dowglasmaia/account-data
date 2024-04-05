package com.maia.accountdata.entrypoint.controller.response;

import lombok.Data;

@Data
public class AddressResponse {
    private String street;
    private String number;
    private String city;
    private String state;
    private String neighborhood;
    private String zip;
}
