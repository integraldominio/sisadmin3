package com.idomine.admin.infrastructure.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.idomine.admin.domain.familia.model.vo.Cor;

@Converter(autoApply = true)
public class CorAttributeConverter implements AttributeConverter<Cor, String>
{
    @Override
    public String convertToDatabaseColumn(Cor value)
    {
        return value != null ? value.getValue() : null;
    }

    @Override
    public Cor convertToEntityAttribute(String value)
    {
        return Cor.getTipo(value);
    }

}
