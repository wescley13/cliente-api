package br.com.surittec.clientes.application;

import br.com.surittec.clientes.domain.ClienteRepository;
import br.com.surittec.clientes.domain.model.Cliente;
import br.com.surittec.clientes.interfaces.dto.ClienteDTO;
import br.com.surittec.clientes.interfaces.dto.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClienteService {

    private final ClienteRepository clienteRepository;

    private final ClienteMapper clienteMapper;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public Cliente salvarCliente(ClienteDTO clienteDTO){
        Cliente cliente = clienteMapper.toClienteDTO(clienteDTO);
        return clienteRepository.save(cliente);
    }

    public void alterarCliente(ClienteDTO clienteDTO){
        Cliente cliente = clienteMapper.toClienteDTO(clienteDTO);
        clienteRepository.save(cliente);
    }

    @Transactional(readOnly = true)
    public ClienteDTO consultarCliente(Long idCliente){
        ClienteDTO clienteDTO = new ClienteDTO();
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);

        if(cliente.isPresent()){
            clienteDTO = clienteMapper.fromCliente(cliente.get());
        }

        return clienteDTO;
    }

    @Transactional(readOnly = true)
    public Page<ClienteDTO> listarClientes(Pageable page){
        Page<Cliente> lista = clienteRepository.findAll(page);

        List<ClienteDTO> listaDto = lista.getContent()
                .stream()
                .map(cli -> clienteMapper.fromCliente(cli))
                .collect(Collectors.toList());

        return new PageImpl<ClienteDTO>(listaDto, page, lista.getTotalElements());
    }

    public void excluirCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
