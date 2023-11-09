package asac.coupang.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryId;

    private String address;
    private Long status; //  배송 완료 여부

    @OneToOne
    @JoinColumn(name="productOrder_id")
    private ProductOrder productOrder;
}
