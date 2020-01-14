package br.com.surittec.clientes.commons;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MainExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DetalhamentoErroExcecao> validacaoHandler(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();

            errors.put(fieldName, errorMessage);
        });

        DetalhamentoErroExcecao erroExcecao = new DetalhamentoErroExcecao(LocalDateTime.now(), "Paramentros Requisicao Invalidos", gerarMensagemErro(errors));

        return new ResponseEntity<DetalhamentoErroExcecao>(erroExcecao, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DetalhamentoErroExcecao> validacaoHandler(Exception ex, WebRequest request) {
        DetalhamentoErroExcecao erroExcecao = new DetalhamentoErroExcecao(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(erroExcecao, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String gerarMensagemErro(Map<String, String> errors){
        StringBuilder mensagemErro = new StringBuilder();
        String mensagemPadrao = "%s: %s";

        errors.forEach((key, value) ->{
            mensagemErro.append(String.format(mensagemPadrao, key, value));
        });

        return mensagemErro.toString();
    }
}
