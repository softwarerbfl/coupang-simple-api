package asac.coupang.controller;

import asac.coupang.dto.ProductDetailDto;
import asac.coupang.dto.ProductDto;
import asac.coupang.dto.ProductUpdateDto;
import asac.coupang.entity.Product;
import asac.coupang.repository.ProductRepository;
import asac.coupang.service.ProductService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //상품 삭제
    @DeleteMapping("/product/{id}/delete")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        return productService.deleteProduct(id);
    }

    //상품 수정
    @PutMapping("/product/{id}/update")
    public ResponseEntity<Product> updateProduct(@PathVariable String id,
                                                 @RequestBody ProductUpdateDto dto){
        Product updateProduct = productService.updateProduct(id, dto);
        return ResponseEntity.ok(updateProduct);
    }

    //원하는 카테고리에 해당하는 상품 조회
    @GetMapping("/product")
    public ResponseEntity<List<Product>> findByCategory(@RequestParam String category){
        List<Product> products = productService.findByCategory(category);
        return ResponseEntity.ok(products);
    }
}
