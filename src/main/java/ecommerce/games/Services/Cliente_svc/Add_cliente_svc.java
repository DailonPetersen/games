package ecommerce.games.Services.Cliente_svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ecommerce.games.Entitys.Cliente;
import ecommerce.games.Repository.Cliente_repo;

@Service
public class Add_cliente_svc {

    @Autowired
    private Cliente_repo cliente_repo;

    public ResponseEntity<Cliente> execute(Cliente cliente){
        cliente_repo.save(cliente);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
