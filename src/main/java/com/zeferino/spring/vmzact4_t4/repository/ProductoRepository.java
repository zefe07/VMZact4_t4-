package com.zeferino.spring.vmzact4_t4.repository;

import com.zeferino.spring.vmzact4_t4.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}