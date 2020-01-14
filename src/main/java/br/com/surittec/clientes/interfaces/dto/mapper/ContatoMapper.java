package br.com.surittec.clientes.interfaces.dto.mapper;

import br.com.surittec.clientes.domain.model.Contato;
import br.com.surittec.clientes.interfaces.dto.ContatoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContatoMapper {

    ContatoMapper MAPPER = Mappers.getMapper(ContatoMapper.class);

    Contato toContatoDto(ContatoDTO contatoDTO);

    @InheritInverseConfiguration
    ContatoDTO fromContato(Contato contato);
}
