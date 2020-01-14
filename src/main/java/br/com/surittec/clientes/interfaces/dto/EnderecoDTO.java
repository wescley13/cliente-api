package br.com.surittec.clientes.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EnderecoDTO {

    @JsonProperty("id")
    private Long id;

    @NotNull(message = "Cep é obrigatorio")
    @JsonProperty("cep")
    private Integer cep;
    @NotEmpty(message = "Preenchimento Obrigatorio")
    @JsonProperty("logradouro")
    private String logradouro;
    @NotEmpty(message = "Preenchimento Obrigatorio")
    @JsonProperty("bairro")
    private String bairro;
    @NotEmpty(message = "Preenchimento Obrigatorio")
    @JsonProperty("cidade")
    private String cidade;
    @NotEmpty(message = "Preenchimento Obrigatorio")
    @JsonProperty("uf")
    private String uf;
}
