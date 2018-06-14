package com.idomine.admin.domain.familia.model.vo;

import java.util.HashMap;
import java.util.Map;

public enum Situacao
{
    Ativo("A"),
    Inativo("I");
    
    private String value;

    private Situacao(String value)
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
    
    public static Situacao getTipo(String value)
    {
        if (value != null)
        {
            switch (value)
            {
                case "A":
                    return Situacao.Ativo;
                case "I":
                    return Situacao.Inativo;
            }
        }
        return Situacao.Ativo;
    }

    public static Map<String, Situacao> listar()
    {
        Map<String, Situacao> lista = new HashMap<>();
        lista.put("Ativo", Situacao.Ativo);
        lista.put("Inativo", Situacao.Inativo);
        return lista;
    }
}
