package asac.coupang.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName; //상품 이름
    private String productDetail; // 상품 상세 설명
    private Long productPrice; // 상품 가격
    private Category category; //카테고리
    private Long amount; // 상품 재고

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;
}
