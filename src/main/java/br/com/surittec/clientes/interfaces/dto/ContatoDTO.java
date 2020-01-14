package br.com.surittec.clientes.interfaces.dto;

import br.com.surittec.clientes.domain.enums.TipoTelefone;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ContatoDTO {

    @JsonProperty("id")
    private Long id;

    @NotNull(message = "Número telefone obrigatorio")
    @JsonProperty("telefone")
    private Integer telefone;

    @NotNull(message = "Informar tipo telefone")
    @JsonProperty("tipoTelefone")
    private TipoTelefone tipoTelefone;
}
