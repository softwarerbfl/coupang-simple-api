package asac.coupang.service;

import asac.coupang.dto.ProductDetailDto;
import asac.coupang.dto.ProductDto;
import asac.coupang.entity.Category;
import asac.coupang.entity.Product;
import asac.coupang.entity.Seller;
import asac.coupang.repository.ProductRepository;
import asac.coupang.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final SellerRepository sellerRepository;
    private final ProductRepository productrepository;
    // 상품 ID에 해당하는 상품의 디테일 정보 조회
    public ResponseEntity<ProductDetailDto> getProductDetail(String id){
        Optional<Product> product = productrepository.findById(Long.valueOf(id));
        if(product.isPresent()){
            log.info("Product 발견!");
            ProductDetailDto dto = new ProductDetailDto();
            dto.setDetail(product.get().getProductDetail());
            return ResponseEntity.ok(dto);
        }
        else{
            log.info("Product 못찾음 ㅜㅜ");
            return null;
        }
    }
    // 상품 등록
    public ResponseEntity<String> addProduct(String sellerId,
                                              ProductDto dto){
        Optional<Seller> seller = sellerRepository.findById(Long.valueOf(sellerId));
        if(seller.isPresent()){
            Product product = new Product();
            product.setProductDetail(dto.getProductDetail());
            product.setProductName(dto.getProductName());
            product.setProductPrice(dto.getProductPrice());
            product.setCategory(Category.valueOf(dto.getCategory()));
            product.setAmount(dto.getAmount());
            product.setSeller(seller.get());
            productrepository.save(product);
            return ResponseEntity.ok("Success Add Product!");
        }
        else{
            return ResponseEntity.ofNullable("No seller");
        }

    }


    // 상품 ID에 해당하는 상품 삭제
    public ResponseEntity<String> deleteProduct(String id){
        productrepository.deleteById(Long.valueOf(id));
        return ResponseEntity.ok("Success Delete Product!");
    }

}
