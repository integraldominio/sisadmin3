package com.idomine.admin.domain.privilegio.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.idomine.admin.domain.privilegio.model.vo.Funcionalidade;
import com.idomine.admin.domain.privilegio.model.vo.SituacaoUsuario;
import com.idomine.admin.infrastructure.converters.FuncionalidadeAttributeConverter;
import com.idomine.admin.infrastructure.converters.SituacaoUsuarioAttributeConverter;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@EqualsAndHashCode(of = { "id" })
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String login;

    private String senha;

    private String email;

    @Convert(converter = SituacaoUsuarioAttributeConverter.class)
    private SituacaoUsuario situacao;

    @Convert(converter = FuncionalidadeAttributeConverter.class)
    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name="funcionalidade")
    private Collection<Funcionalidade> funcionalidades;
    
    public Usuario(String nome, String senha)
    {
        this.nome = nome;
        this.senha = senha;
    }
    
    public boolean isIncluindo() {
        return id == null ? true : false;
    }
    
    public boolean isEditando() {
        return !isIncluindo();
    }
    
}
