package com.idomine.admin.infrastructure.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.idomine.admin.domain.privilegio.model.vo.SituacaoUsuario;

@Converter(autoApply = true)
public class SituacaoUsuarioAttributeConverter implements AttributeConverter<SituacaoUsuario, String>
{
    @Override
    public String convertToDatabaseColumn(SituacaoUsuario value)
    {
        return value != null ? value.getValue() : null;
    }

    @Override
    public SituacaoUsuario convertToEntityAttribute(String value)
    {
        return SituacaoUsuario.getTipo(value);
    }

}
