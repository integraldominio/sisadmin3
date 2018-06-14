package com.idomine.admin.infrastructure.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.idomine.admin.domain.familia.model.vo.SimNao;

@Converter(autoApply = true)
public class SimNaoAttributeConverter implements AttributeConverter<SimNao, String>
{
    @Override
    public String convertToDatabaseColumn(SimNao value)
    {
        return value != null ? value.getValue() : null;
    }

    @Override
    public SimNao convertToEntityAttribute(String value)
    {
        return SimNao.getTipo(value);
    }

}
