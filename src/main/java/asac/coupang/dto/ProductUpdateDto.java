package asac.coupang.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@Data
public class ProductUpdateDto {
    String productName;
    String productDetail;
    Long productPrice;
    String category;
    Long amount;
}
