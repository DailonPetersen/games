package ecommerce.games.Entitys;

import java.util.List;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carrinho;
    private Long id_cliente;
    @ManyToOne
    private Produto lista_protudos;

}
