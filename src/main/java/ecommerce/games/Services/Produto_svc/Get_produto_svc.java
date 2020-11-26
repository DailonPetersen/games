package ecommerce.games.Services.Produto_svc;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.games.Entitys.Produto;
import ecommerce.games.Repository.Produto_repo;

@Service
public class Get_produto_svc {

    @Autowired
    private Produto_repo produto_repo;

    public Produto execute(Long id) {
        return produto_repo.findProduct(id);
    }
    
    public List<Produto> execute(){
        return produto_repo.findAll();
    }
}
