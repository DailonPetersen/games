package ecommerce.games.Services.Cliente_svc;

import javax.persistence.Access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ecommerce.games.Entitys.Cliente;
import ecommerce.games.Repository.Cliente_repo;

@Service
public class Del_cliente_svc {

    @Autowired
    private Cliente_repo cliente_repo;

    public ResponseEntity<Cliente> execute(Long id){
        try{
            cliente_repo.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
