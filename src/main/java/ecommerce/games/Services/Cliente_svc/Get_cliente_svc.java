package ecommerce.games.Services.Cliente_svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import ecommerce.games.Entitys.Cliente;
import ecommerce.games.Repository.Cliente_repo;

@Service
public class Get_cliente_svc {
    
    @Autowired
    private Cliente_repo cliente_repo;

    public Cliente execute(Long id){
        return cliente_repo.getOne(id);
    }

    public List<Cliente> execute(){
        return cliente_repo.findAll();
    }
}
