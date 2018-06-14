package com.idomine.admin.domain.familia.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

import com.idomine.admin.domain.familia.model.vo.SimNao;
import com.idomine.admin.domain.familia.model.vo.Situacao;
import com.idomine.admin.domain.privilegio.model.Usuario;
import com.idomine.admin.infrastructure.converters.SimNaoAttributeConverter;
import com.idomine.admin.infrastructure.converters.SituacaoAttributeConverter;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("deprecation")
@Entity
@Setter
@Getter
@EqualsAndHashCode(of = { "id" })
public class Familia implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty
    private String nomeMae;
    
    @NotEmpty
    private String endereco;

    private Date criacao;

    private String pontoReferencia;
    
    @Convert(converter=SimNaoAttributeConverter.class)
    private SimNao recebeAjudaProgSocial;
    
    @Convert(converter=SituacaoAttributeConverter.class)
    private Situacao situacao;
    
    @OneToMany(mappedBy="familia",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Membro> membros;
    
    @ManyToOne
    private Bairro bairro;

    @ManyToOne
    private Usuario usuario;
    
    public boolean isIncluindo() {
        return id == null ? true : false;
    }
    
    public boolean isEditando() {
        return !isIncluindo();
    }

    
    public Familia()
    {
        membros= new ArrayList<>();
        situacao=Situacao.Ativo;
        criacao=new Date();
    }
}
