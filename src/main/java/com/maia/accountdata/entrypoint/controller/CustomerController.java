package com.maia.accountdata.entrypoint.controller;

import com.maia.accountdata.core.usecase.FindCustomerByIdUseCase;
import com.maia.accountdata.core.usecase.InsertCustomerUseCase;
import com.maia.accountdata.entrypoint.controller.mapper.CustomerRequestMapper;
import com.maia.accountdata.entrypoint.controller.request.CustomerRequest;
import com.maia.accountdata.entrypoint.controller.response.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerRequestMapper mapper;

    private final InsertCustomerUseCase insertCustomerUseCase;
    private final FindCustomerByIdUseCase findCustomerByIdUseCase;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest request) {
        var customer = mapper.toCustomer(request);
        insertCustomerUseCase.insert(customer, request.getZipCode());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable String id) {
        var customer = findCustomerByIdUseCase.find(id);
        var customerResponse = mapper.toCustomerResponse(customer);
        return ResponseEntity.status(HttpStatus.OK).body(customerResponse);
    }

}
