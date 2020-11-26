package ecommerce.games.Entitys;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_cliente;
    private String nome;
    private String sobrenome;
    @ManyToOne
    private Endereco endereco;
    private String CPF;
    private String telefone;
    private String email;

}