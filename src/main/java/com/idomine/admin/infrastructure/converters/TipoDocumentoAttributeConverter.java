package com.idomine.admin.infrastructure.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.idomine.admin.domain.familia.model.vo.TipoDocumento;

@Converter(autoApply = true)
public class TipoDocumentoAttributeConverter implements AttributeConverter<TipoDocumento, String>
{
    @Override
    public String convertToDatabaseColumn(TipoDocumento value)
    {
        return value != null ? value.getValue() : null;
    }

    @Override
    public TipoDocumento convertToEntityAttribute(String value)
    {
        return TipoDocumento.getTipo(value);
    }

}
