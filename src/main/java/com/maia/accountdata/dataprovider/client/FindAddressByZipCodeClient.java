package com.maia.accountdata.dataprovider.client;

import com.maia.accountdata.dataprovider.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "FIndAddressByZipCode",
        url = "${maia.client.address.url}"
)
public interface FindAddressByZipCodeClient {
    @GetMapping("/find-by-zipcode")
    AddressResponse find(@RequestParam("zipCode") String zipCode);
}
