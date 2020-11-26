package ecommerce.games.Entitys;

import java.math.BigDecimal;

import javax.persistence.*;

import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

import lombok.*;

@Entity
@NoArgsConstructor 
@AllArgsConstructor
@Data
public class Produto{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_produto;
    private String nome;
    private String categoria;
    private BigDecimal preco;
    private int quantidade_estoque;

}
