package ecommerce.games.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.games.Entitys.Carrinho;

public interface Carrinho_repo extends JpaRepository<Carrinho, Long>{
    
}
