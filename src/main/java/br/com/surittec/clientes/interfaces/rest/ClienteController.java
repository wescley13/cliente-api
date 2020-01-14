package br.com.surittec.clientes.interfaces.rest;

import br.com.surittec.clientes.application.ClienteService;
import br.com.surittec.clientes.interfaces.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('EDIT')")
    public ResponseEntity inserirCliente(@Valid @RequestBody ClienteDTO cliente){
        clienteService.salvarCliente(cliente);

        return ResponseEntity.ok().build();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('EDIT')")
    public ResponseEntity atualizarCliente(@Valid @RequestBody ClienteDTO cliente){
        clienteService.alterarCliente(cliente);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity consultarCliente(@PathVariable Long id){
        ClienteDTO cliente = clienteService.consultarCliente(id);

        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping
    public ResponseEntity consultarTodosClientes(Pageable paginacao){
        Page<ClienteDTO> clientes = clienteService.listarClientes(paginacao);

        return ResponseEntity.ok().body(clientes);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('EDIT')")
    public void excluirCliente(@PathVariable  Long id){
        clienteService.excluirCliente(id);
    }
}
