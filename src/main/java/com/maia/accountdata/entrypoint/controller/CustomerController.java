package com.maia.accountdata.entrypoint.controller;

import com.maia.accountdata.core.usecase.customer.*;
import com.maia.accountdata.entrypoint.controller.mapper.CustomerRequestMapper;
import com.maia.accountdata.entrypoint.controller.request.CustomerRequest;
import com.maia.accountdata.entrypoint.controller.response.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerRequestMapper mapper;

    private final InsertUseCase insertUseCase;
    private final FindByIdUseCase findByIdUseCase;
    private final FindAllUseCase findAllUseCase;
    private final UpdateUseCase updateUseCase;
    private final DeleteUseCase deleteUseCase;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest request) {
        var customer = mapper.toCustomer(request);
        var customerSaved = insertUseCase.insert(customer, request.getZipCode());

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(customerSaved.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable String id) {
        var customer = findByIdUseCase.find(id);
        var customerResponse = mapper.toCustomerResponse(customer);
        return ResponseEntity.status(HttpStatus.OK)
                .body(customerResponse);
    }

    @GetMapping()
    public ResponseEntity<List<CustomerResponse>> findAll() {
        var customers = findAllUseCase.find();
        var customersResponse = mapper.toCustomersResponse(customers);
        return ResponseEntity.ok().body(customersResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> update(@Valid @RequestBody CustomerRequest request, @PathVariable String id) {
        var customer = mapper.toCustomer(request);
        var customerUpdated = updateUseCase.update(customer, request.getZipCode(), id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(mapper.toCustomerResponse(customerUpdated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        deleteUseCase.delete(id);

        return ResponseEntity.noContent().build();
    }

}
