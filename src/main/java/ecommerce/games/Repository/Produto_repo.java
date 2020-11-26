package ecommerce.games.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ecommerce.games.Entitys.Produto;

public interface Produto_repo extends JpaRepository<Produto, Long> {
    
    @Query(value="SELECT u FROM Produto u WHERE id = ?1")
	Produto findProduct(Long id);
}
