package asac.coupang.service;

import asac.coupang.dto.ProductDetailDto;
import asac.coupang.dto.ProductDto;
import asac.coupang.dto.ProductUpdateDto;
import asac.coupang.entity.Category;
import asac.coupang.entity.Product;
import asac.coupang.entity.Seller;
import asac.coupang.repository.ProductRepository;
import asac.coupang.repository.ProductRepositoryImpl;
import asac.coupang.repository.SellerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final SellerRepository sellerRepository;
    private final ProductRepository productrepository;
    private final ProductRepositoryImpl productRepositoryImpl;

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

    // 상품 ID에 해당하는 상품 수정
    public Product updateProduct(String id, ProductUpdateDto dto) {
        Product product = productrepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new EntityNotFoundException("Product Not Found"));
        if (dto.getProductName()!=null){
            product.setProductName(dto.getProductName());
        }
        if(dto.getProductDetail()!=null){
            product.setProductDetail(dto.getProductDetail());
        }
        if(dto.getProductPrice()!=null){
            product.setProductPrice(dto.getProductPrice());
        }
        if(dto.getCategory()!=null){
            product.setCategory(Category.valueOf(dto.getCategory()));
        }
        if(dto.getAmount()!=null){
            product.setAmount(dto.getAmount());
        }
        return productrepository.save(product);
    }

    // 원하는 카테고리에 해당하는 상품 조회
    public List<Product> findByCategory(String category){
        List<Product> products = productrepository.findByCategory(Category.valueOf(category));
        return products;
    }

    // 전체 상품 조회
    public List<Product> findAll(){
        List<Product> products = productRepositoryImpl.findAll();
        return products;
    }
    // 원하는 Seller가 판매하는 상품들 불러오기
    public List<Product> findBySeller(Long sellerId){
        Optional<Seller> seller = sellerRepository.findById(sellerId);
        if(seller.isPresent()){
            List<Product> products = productRepositoryImpl.findBySeller(seller.get());
            return products;
        }
        else{
            return null;
        }
    }

}
