package br.com.surittec.clientes.commons;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class DetalhamentoErroExcecao {

    public DetalhamentoErroExcecao(LocalDateTime hora, String mensagem, String detalhamento) {
        this.hora = hora;
        this.mensagem = mensagem;
        this.detalhamento = detalhamento;
    }

    private LocalDateTime hora;
    private String mensagem;
    private String detalhamento;
}
