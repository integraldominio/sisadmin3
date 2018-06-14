package com.idomine.admin.domain.familia.model.vo;

import java.util.HashMap;
import java.util.Map;

public enum EstadoCivil
{
    Casado("Casado"), Solteiro("Solteiro"), Divorciado("Divorciado"),Viuvo("Viuvo");

    private String value;

    private EstadoCivil(String value)
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

    public static EstadoCivil getTipo(String value)
    {
        if (value != null)
        {
            switch (value)
            {
                case "Casado":
                    return EstadoCivil.Casado;
                case "Solteiro":
                    return EstadoCivil.Solteiro;
                case "Divorciado":
                    return EstadoCivil.Divorciado;
                case "Viuvo":
                    return EstadoCivil.Viuvo;
            }
        }
        return EstadoCivil.Solteiro;
    }

    public static Map<String, EstadoCivil> listar()
    {
        Map<String, EstadoCivil> lista = new HashMap<>();
        lista.put("Casado", EstadoCivil.Casado);
        lista.put("Solteiro", EstadoCivil.Solteiro);
        lista.put("Divorciado", EstadoCivil.Divorciado);
        lista.put("Viúvo", EstadoCivil.Viuvo);
        return lista;
    }
}
