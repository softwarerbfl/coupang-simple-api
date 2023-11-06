package asac.coupang.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ProductDto {
    String productName;
    String productDetail;
    Long productPrice;
    String category;
    Long amount;
}
