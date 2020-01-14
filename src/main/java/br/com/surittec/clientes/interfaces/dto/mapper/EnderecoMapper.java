package br.com.surittec.clientes.interfaces.dto.mapper;

import br.com.surittec.clientes.domain.model.Endereco;
import br.com.surittec.clientes.interfaces.dto.EnderecoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EnderecoMapper {

    EnderecoMapper MAPPER = Mappers.getMapper(EnderecoMapper.class);

    Endereco toEnderecoDTO(EnderecoDTO enderecoDTO);

    @InheritInverseConfiguration
    EnderecoDTO fromEndereco(Endereco endereco);
}
