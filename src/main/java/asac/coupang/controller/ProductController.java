package asac.coupang.controller;

import asac.coupang.dto.ProductDetailDto;
import asac.coupang.dto.ProductDto;
import asac.coupang.entity.Product;
import asac.coupang.repository.ProductRepository;
import asac.coupang.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // 상품 ID에 해당하는 상품의 디테일 정보 조회
    @GetMapping("/product/{id}/detail")
    public ResponseEntity<ProductDetailDto> getProductDetail(@PathVariable String id) {
        return productService.getProductDetail(id);
    }

    // 상품 등록
    @PostMapping("/product/add/{sellerId}")
    public ResponseEntity<String> addProduct(@PathVariable String sellerId,
                                             @RequestBody ProductDto dto) {
        return productService.addProduct(sellerId, dto);
    }

    @DeleteMapping("/product/{id}/delete")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        return productService.deleteProduct(id);
    }
}
