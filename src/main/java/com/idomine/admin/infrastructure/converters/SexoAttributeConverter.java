package com.idomine.admin.infrastructure.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.idomine.admin.domain.familia.model.vo.Sexo;

@Converter(autoApply = true)
public class SexoAttributeConverter implements AttributeConverter<Sexo, String>
{
    @Override
    public String convertToDatabaseColumn(Sexo value)
    {
        return value != null ? value.getValue() : null;
    }

    @Override
    public Sexo convertToEntityAttribute(String value)
    {
        return Sexo.getTipo(value);
    }

}
