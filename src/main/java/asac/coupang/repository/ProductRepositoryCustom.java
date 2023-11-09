package asac.coupang.repository;

import asac.coupang.entity.Product;
import asac.coupang.entity.Seller;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> findBySeller(Seller seller);
    List<Product> findAll();
}
