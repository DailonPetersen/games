package ecommerce.games.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.games.Entitys.Cliente;

public interface Cliente_repo extends JpaRepository<Cliente, Long>{
    
}
