package asac.coupang.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sellerId;
    private String sellerName;
    private String sellerNumber; //사업자 등록 번호

    @JsonIgnore
    @OneToMany(mappedBy = "seller")
    private List<Product> productList = new ArrayList<>();
}
