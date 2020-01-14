package br.com.surittec.clientes.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "TB_ENDERECO")
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name = "NR_CEP", length = 7)
    private Integer cep;
    @Column(name = "DS_LOGRADOURO", length = 100)
    private String logradouro;
    @Column(name = "NM_BAIRRO", length = 100)
    private String bairro;
    @Column(name = "NM_CIDADE", length = 100)
    private String cidade;
    @Column(name = "NM_UF", length = 2)
    private String uf;

}
