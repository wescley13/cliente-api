package br.com.surittec.clientes.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
public class ClienteDTO {

    @JsonProperty("id")
    private Long id;

    @NotEmpty(message = "Preenchimento obrigatorio")
    @Size(min = 3, max = 100, message = "Tamanho minimo de 3 e maximo de 100")
    @JsonProperty("nome")
    private String nome;

    @Column(name = "NR_CPF", length = 11, unique = true)
    @NotNull(message = "Preenchimento obrigatorio")
    @JsonProperty("cpf")
    private Long cpf;

    @NotNull(message = "Enderco nulo")
    @JsonProperty("endereco")
    private EnderecoDTO endereco;

    @Size(min = 1, message = "Pelo menos um telefone deve ser informado")
    @JsonProperty("contatos")
    private Set<ContatoDTO> contatos = new HashSet<>();

    @Size(min = 1, message = "Informe um email")
    @JsonProperty("email")
    private Set<String> email = new HashSet<>();
}
