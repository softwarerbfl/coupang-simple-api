package asac.coupang.service;

import asac.coupang.dto.CustomerDto;
import asac.coupang.entity.Customer;
import asac.coupang.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    // 소비자(Customer) 추가
    public Customer addCustomer(CustomerDto dto){
        Customer customer = new Customer();
        customer.setCustomerName(dto.getCustomerName());
        customer.setAddress(dto.getAddress());
        customerRepository.save(customer);
        return customer;
    }

    // 소비자(Customer) 전체 조회
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }


}
