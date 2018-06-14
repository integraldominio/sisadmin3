package com.idomine.admin.infrastructure.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.idomine.admin.domain.familia.model.vo.NivelInstrucao;

@Converter(autoApply = true)
public class NivelInstrucaoAttributeConverter implements AttributeConverter<NivelInstrucao, String>
{
    @Override
    public String convertToDatabaseColumn(NivelInstrucao value)
    {
        return value != null ? value.getValue() : null;
    }

    @Override
    public NivelInstrucao convertToEntityAttribute(String value)
    {
        return NivelInstrucao.getTipo(value);
    }

}
