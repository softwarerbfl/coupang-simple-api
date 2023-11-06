package asac.coupang.service;

import asac.coupang.dto.SellerDto;
import asac.coupang.entity.Seller;
import asac.coupang.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SellerService {
    private final SellerRepository sellerRepository;

    // 판매자 계정 추가
    public ResponseEntity<Seller> addSeller(SellerDto sellerDto) {
        Seller seller = new Seller();
        seller.setSellerName(sellerDto.getSellerName());
        seller.setSellerNumber(sellerDto.getSellerNumber());
        sellerRepository.save(seller);
        return ResponseEntity.ok(seller);
    }
}
