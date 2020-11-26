package ecommerce.games.Services.Produto_svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ecommerce.games.Entitys.Produto;
import ecommerce.games.Repository.Produto_repo;
import ecommerce.games.util.Upload;

@Service
public class Add_produto_svc {
    
    @Autowired
    private Produto_repo produto_repo;

    @Autowired
    private Upload upload;

    public ResponseEntity<Produto> execute(Produto produto){
        //upload.salvarFoto(produto.getImagem());
        produto_repo.save(produto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    
    
}
