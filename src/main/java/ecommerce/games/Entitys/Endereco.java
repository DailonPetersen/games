package ecommerce.games.Entitys;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    public String logradouro;
    public String numero;
    public String bairro;
    public String CEP;
    public String cidade;
    public String UF;

}