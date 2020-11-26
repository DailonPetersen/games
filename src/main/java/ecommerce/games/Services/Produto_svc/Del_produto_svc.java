package ecommerce.games.Services.Produto_svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ecommerce.games.Repository.Produto_repo;

@Service
public class Del_produto_svc {

    @Autowired
    private Produto_repo produto_repo;

    public ResponseEntity execute(Long id){
        try{
            produto_repo.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
