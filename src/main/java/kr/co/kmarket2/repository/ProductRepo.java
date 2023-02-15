package kr.co.kmarket2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.kmarket2.entity.ProductEntity;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer>{

}
