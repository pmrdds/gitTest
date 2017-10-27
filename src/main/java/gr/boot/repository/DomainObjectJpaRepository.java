package gr.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gr.boot.model.DomainObject;

public interface DomainObjectJpaRepository extends JpaRepository<DomainObject, Integer> {
	
	List <DomainObject> findByPriceGreaterThanAndPriceLessThan(Double price1 , Double price2);
	List <DomainObject> findByNameOrderByPriceAsc(String name);
}
