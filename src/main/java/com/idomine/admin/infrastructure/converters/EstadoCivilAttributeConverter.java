package com.idomine.admin.infrastructure.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.idomine.admin.domain.familia.model.vo.EstadoCivil;

@Converter(autoApply = true)
public class EstadoCivilAttributeConverter implements AttributeConverter<EstadoCivil, String>
{
    @Override
    public String convertToDatabaseColumn(EstadoCivil value)
    {
        return value != null ? value.getValue() : null;
    }

    @Override
    public EstadoCivil convertToEntityAttribute(String value)
    {
        return EstadoCivil.getTipo(value);
    }

}
