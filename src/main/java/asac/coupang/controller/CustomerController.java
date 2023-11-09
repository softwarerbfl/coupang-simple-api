package asac.coupang.controller;

import asac.coupang.dto.CustomerDto;
import asac.coupang.entity.Customer;
import asac.coupang.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    // 소비자(Customer) 추가
    @PostMapping("/customer/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody CustomerDto dto) {
        Customer customer = customerService.addCustomer(dto);
        return ResponseEntity.ok(customer);
    }

    // 소비자(Customer) 전체 조회
    @GetMapping("/customer/all")
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }
}
