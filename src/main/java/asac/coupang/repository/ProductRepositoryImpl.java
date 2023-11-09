package asac.coupang.repository;

import asac.coupang.entity.Product;
import asac.coupang.entity.Seller;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static asac.coupang.entity.QProduct.product;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Product> findBySeller(Seller seller) {
        return jpaQueryFactory.selectFrom(product)
                .where(
                        product.seller.eq(seller)
                )
                .fetch();
    }

    @Override
    public List<Product> findAll() {
        return jpaQueryFactory.selectFrom(product)
                .fetch();
    }

}
