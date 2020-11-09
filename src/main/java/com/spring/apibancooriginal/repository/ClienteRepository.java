package com.spring.apibancooriginal.repository;

import com.spring.apibancooriginal.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
