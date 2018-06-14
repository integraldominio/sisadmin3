package com.idomine.admin.infrastructure.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.idomine.admin.domain.familia.model.vo.Situacao;

@Converter(autoApply = true)
public class SituacaoAttributeConverter implements AttributeConverter<Situacao, String>
{
    @Override
    public String convertToDatabaseColumn(Situacao value)
    {
        return value != null ? value.getValue() : null;
    }

    @Override
    public Situacao convertToEntityAttribute(String value)
    {
        return Situacao.getTipo(value);
    }

}
