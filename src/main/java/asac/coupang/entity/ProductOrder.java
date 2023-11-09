package asac.coupang.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ProductOrder")
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productOrderId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders orders;

    @OneToOne(mappedBy = "productOrder", cascade = CascadeType.ALL)
    private Delivery delivery;
}
