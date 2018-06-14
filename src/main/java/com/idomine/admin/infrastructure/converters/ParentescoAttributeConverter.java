package com.idomine.admin.infrastructure.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.idomine.admin.domain.familia.model.vo.Parentesco;

@Converter(autoApply = true)
public class ParentescoAttributeConverter implements AttributeConverter<Parentesco, String>
{
    @Override
    public String convertToDatabaseColumn(Parentesco value)
    {
        return value != null ? value.getValue() : null;
    }

    @Override
    public Parentesco convertToEntityAttribute(String value)
    {
        return Parentesco.getTipo(value);
    }

}
