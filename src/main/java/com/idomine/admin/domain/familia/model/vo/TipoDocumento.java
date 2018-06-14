package com.idomine.admin.domain.familia.model.vo;

import java.util.HashMap;
import java.util.Map;

public enum TipoDocumento
{
    NaoInformado("NA"),
    Identidade("ID"),
    CertidaoNascimento("CN"),
    Outro("OU");
    
    private String value;

    private TipoDocumento(String value)
    {
        this.setValue(value);
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }
    
    public static TipoDocumento getTipo(String value)
    {
        if (value != null)
        {
            switch (value)
            {
                case "NA":
                    return TipoDocumento.NaoInformado;
                case "ID":
                    return TipoDocumento.Identidade;
                case "CN":
                    return TipoDocumento.CertidaoNascimento;
                case "OU":
                    return TipoDocumento.Outro;
            }
        }
        return TipoDocumento.NaoInformado;
    }

    public static Map<String, TipoDocumento> listar()
    {
        Map<String, TipoDocumento> lista = new HashMap<>();
        lista.put("Não Informado", TipoDocumento.NaoInformado);
        lista.put("Identidade", TipoDocumento.Identidade);
        lista.put("Certidão Nascimento", TipoDocumento.CertidaoNascimento);
        lista.put("Outro", TipoDocumento.Outro);
        return lista;
    }
}
