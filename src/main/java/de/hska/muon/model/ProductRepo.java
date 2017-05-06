package de.hska.muon.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query("select p from Product p where (p.name like %?1% or p.details like %?1% ) AND (p.price between ?2 AND ?3)")
    public Iterable<Product> findProductFilterWithQuery(String query, Integer minPrice, Integer maxPrice);

    @Query("select p from Product p where p.price between ?1 AND ?2")
    public Iterable<Product> findProductFilter(Integer minPrice, Integer maxPrice);
}