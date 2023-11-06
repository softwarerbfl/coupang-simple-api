package asac.coupang.controller;

import asac.coupang.dto.SellerDto;
import asac.coupang.entity.Seller;
import asac.coupang.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SellerController {
    private final SellerService sellerService;
    @PostMapping("/seller/add")
    public ResponseEntity<Seller> addSeller(@RequestBody SellerDto sellerDto){
        return sellerService.addSeller(sellerDto);
    }

}
