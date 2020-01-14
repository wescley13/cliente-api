package br.com.surittec.clientes.domain.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "TB_CLINTE")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "NM_CLIENTE", length = 100)
    private String nome;

    @Column(name = "NR_CPF", length = 11, unique = true)
    private Integer cpf;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CLIENTE")
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CLIENTE")
    private Set<Contato> contatos = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "TB_EMAIL_CLIENTE", joinColumns = @JoinColumn(name = "ID_CLIENTE"))
    @Column(name = "DS_EMAIL")
    private Set<String> email = new HashSet<>();

    @CreatedBy
    private User usuarioCriacao;

    @LastModifiedBy
    private User usuarioAtualizacao;

    @CreatedBy
    @Column(name = "DT_CRIACAO")
    private LocalDateTime dataCriacao;

    @LastModifiedDate
    @Column(name = "DT_ATUALIZACAO")
    private LocalDateTime dataModificacao;

}