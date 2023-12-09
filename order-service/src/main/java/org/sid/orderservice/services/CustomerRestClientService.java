package org.sid.orderservice.services;

import org.sid.orderservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
//si j'appelle cette interface   envoie une requette a le service customer-service
public interface CustomerRestClientService {
    @GetMapping("/customers/{id}?projection=fullCustomer")
    Customer customerById(@PathVariable Long id);
    @GetMapping("/customers?projection=fullCustomer")
    PagedModel<Customer> allCustomers();
}