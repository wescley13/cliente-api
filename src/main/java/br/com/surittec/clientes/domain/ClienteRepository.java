package br.com.surittec.clientes.domain;

import br.com.surittec.clientes.domain.model.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

@Component
public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {

}
