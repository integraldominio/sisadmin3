package com.idomine.admin.infrastructure.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.idomine.admin.domain.privilegio.model.vo.Funcionalidade;

@Converter(autoApply = true)
public class FuncionalidadeAttributeConverter implements AttributeConverter<Funcionalidade, String>
{
    @Override
    public String convertToDatabaseColumn(Funcionalidade value)
    {
        return value != null ? value.getValue() : null;
    }

    @Override
    public Funcionalidade convertToEntityAttribute(String value)
    {
        return Funcionalidade.getTipo(value);
    }

}
