package com.idomine.admin.domain.familia.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.idomine.admin.domain.familia.model.vo.Cor;
import com.idomine.admin.domain.familia.model.vo.EstadoCivil;
import com.idomine.admin.domain.familia.model.vo.NivelInstrucao;
import com.idomine.admin.domain.familia.model.vo.Parentesco;
import com.idomine.admin.domain.familia.model.vo.Sexo;
import com.idomine.admin.domain.familia.model.vo.TipoDocumento;
import com.idomine.admin.infrastructure.converters.CorAttributeConverter;
import com.idomine.admin.infrastructure.converters.EstadoCivilAttributeConverter;
import com.idomine.admin.infrastructure.converters.NivelInstrucaoAttributeConverter;
import com.idomine.admin.infrastructure.converters.ParentescoAttributeConverter;
import com.idomine.admin.infrastructure.converters.SexoAttributeConverter;
import com.idomine.admin.infrastructure.converters.TipoDocumentoAttributeConverter;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@EqualsAndHashCode(of = { "id" })
public class Membro implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    private Familia familia;

    @Convert(converter = ParentescoAttributeConverter.class)
    private Parentesco parentesco;

    private Date nascimento;

    @Convert(converter = SexoAttributeConverter.class)
    private Sexo sexo;

    @Convert(converter = CorAttributeConverter.class)
    private Cor cor;

    @Convert(converter = EstadoCivilAttributeConverter.class)
    private EstadoCivil estadoCivil;

    @Convert(converter = NivelInstrucaoAttributeConverter.class)
    private NivelInstrucao nivelInstrucao;

    @Convert(converter = TipoDocumentoAttributeConverter.class)
    private TipoDocumento tipoDocumento;

    private String numeroDocumento;

    @ManyToOne
    private Ocupacao ocupacao;

    private BigDecimal renda;

    private String previdenciaSocial;

    private String saude;
    
}
