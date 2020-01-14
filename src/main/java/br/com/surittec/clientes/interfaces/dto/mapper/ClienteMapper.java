package br.com.surittec.clientes.interfaces.dto.mapper;

import br.com.surittec.clientes.domain.model.Cliente;
import br.com.surittec.clientes.interfaces.dto.ClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toClienteDTO(ClienteDTO clienteDTO);

    ClienteDTO fromCliente(Cliente cliente);
}
