package com.idomine.admin.domain.privilegio.model.vo;

import java.util.HashMap;
import java.util.Map;

public enum SituacaoUsuario
{
    Ativo("A"), Inativo("I");

    private String value;

    private SituacaoUsuario(String value)
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

    public static SituacaoUsuario getTipo(String value)
    {
        if (value != null)
        {
            switch (value)
            {
                case "A":
                    return SituacaoUsuario.Ativo;
                case "I":
                    return SituacaoUsuario.Inativo;
            }
        }
        return SituacaoUsuario.Ativo;
    }

    public static Map<String, SituacaoUsuario> listar()
    {
        Map<String, SituacaoUsuario> lista = new HashMap<>();
        lista.put("Ativo", SituacaoUsuario.Ativo);
        lista.put("Inativo", SituacaoUsuario.Inativo);
        return lista;
    }
}
