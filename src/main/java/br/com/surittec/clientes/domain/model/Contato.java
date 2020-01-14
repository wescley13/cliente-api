package br.com.surittec.clientes.domain.model;

import br.com.surittec.clientes.domain.enums.TipoTelefone;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "TB_CONTATO")
public class Contato implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "NR_TELEFONE", nullable = false)
    private Integer telefone;

    @Column(name = "TP_TELEFONE", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoTelefone tipoTelefone;

}
