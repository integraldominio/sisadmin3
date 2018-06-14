package com.idomine.admin.domain.familia.model.vo;

import java.util.HashMap;
import java.util.Map;

public enum Cor
{
    Branca("Branca"), Preta("Preta"), Parda("Parda"), Amarela("Amarela"), Indigena("Indigina");

    private String value;

    private Cor(String value)
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

    public static Cor getTipo(String value)
    {
        if (value != null)
        {
            switch (value)
            {
                case "Branca":
                    return Cor.Branca;
                case "Preta":
                    return Cor.Preta;
                case "Parda":
                    return Cor.Parda;
                case "Amarela":
                    return Cor.Amarela;
                case "Indigina":
                    return Cor.Indigena;
            }
        }
        return Cor.Branca;
    }

    public static Map<String, Cor> listar()
    {
        Map<String, Cor> lista = new HashMap<>();
        lista.put("Branca", Cor.Branca);
        lista.put("Preta", Cor.Preta);
        lista.put("Parda", Cor.Parda);
        lista.put("Amarela", Cor.Amarela);
        lista.put("Indígena", Cor.Indigena);
        return lista;
    }
}
