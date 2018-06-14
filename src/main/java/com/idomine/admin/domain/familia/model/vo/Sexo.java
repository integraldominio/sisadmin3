package com.idomine.admin.domain.familia.model.vo;

import java.util.HashMap;
import java.util.Map;

public enum Sexo
{
    Masculino("M"), Feminino("F");

    private String value;

    private Sexo(String value)
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

    public static Sexo getTipo(String value)
    {
        if (value != null)
        {
            switch (value)
            {
                case "M":
                    return Sexo.Masculino;
                case "F":
                    return Sexo.Feminino;
            }
        }
        return Sexo.Masculino;
    }

    public static Map<String, Sexo> listar()
    {
        Map<String, Sexo> lista = new HashMap<>();
        lista.put("Masculino", Sexo.Masculino);
        lista.put("Feminino", Sexo.Masculino);
        return lista;
    }
}
