package com.idomine.admin.infrastructure.helper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public final class StringsHelper
{
    private StringsHelper()
    {
    }

    public static String nuloParaString(Object s)
    {
        return s == null ? "" : s.toString();
    }

    public static long converte(String s)
    {
        long numero = 0;
        try
        {
            numero = Long.valueOf(s.trim()).longValue();
        }
        catch (NumberFormatException e)
        {
        }
        return numero;
    }

    public static boolean stringMaiorQueZero(String s)
    {
        return converte(s) > 0;
    }

    public static String ajustarBarraSeparadora(String s)
    {
        String stringAjustada = s.trim();
        if (s.startsWith("/"))
        {
            return stringAjustada;
        }
        else
        {
            return "/" + stringAjustada;
        }
    }

    public static Object retornarAtributosEmMaiusculas(Object o)
    {
        try
        {
            if (o != null)
                for (Field field : o.getClass().getDeclaredFields())
                {
                    if (field.getType().equals(String.class))
                    {
                        if (!field.isAccessible())
                            field.setAccessible(true);
                        if (field.get(o) != null && ((String) field.get(o)).trim() != "")
                        {
                            field.set(o, ((String) field.get(o)).toUpperCase());
                        }
                    }
                }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return o;
    }

    public static String envolverComLike(String string)
    {
        return "%" + string.toUpperCase().trim().replaceAll("\\s+", "% ") + "%";
    }

    public static String aspasSimples(String string)
    {
        return "'" + string + "'";
    }

    public static List<String> stringToList(String lista, String sep)
    {
        List<String> listaDeps = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(lista, sep);
        while (tokenizer.hasMoreTokens())
        {
            String token = tokenizer.nextToken();
            listaDeps.add(token);
        }
        return listaDeps;
    }

    public static String onlyNumbers(String text)
    {
        return Objects.isNull(text) ? null : text.replaceAll("[^0-9|,]+", "").replaceAll(",", ".");
    }

    public static String escapePrimeFacesClientId(String primeFacesClienId)
    {
        if (Objects.nonNull(primeFacesClienId) && primeFacesClienId.indexOf(":") != -1)
        {
            primeFacesClienId = "#" + primeFacesClienId.replace(":", "\\:");
        }
        return primeFacesClienId;
    }

    public static String objectoToString(Object obj)
    {
        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");

        result.append(obj.getClass().getName());
        result.append(" Object {");
        result.append(newLine);

        // determine fields declared in this class only (no fields of superclass)
        Field[] fields = obj.getClass().getDeclaredFields();

        // print field names paired with their values
        for (Field field : fields)
        {
            field.setAccessible(true);

            result.append("  ");
            try
            {
                result.append(field.getName());
                result.append(": ");
                // requires access to private field:
                result.append(field.get(obj));
            }
            catch (IllegalAccessException ex)
            {
                System.out.println(ex);
            }
            result.append(newLine);
        }
        result.append("}");

        return result.toString();
    }

    public static String removerPalavras(String string, String... subStrings)
    {
        String stringRetorno = string;
        if (subStrings != null)
            for (String s : subStrings)
            {
                stringRetorno = stringRetorno.replace(" " + s.trim() + " ", " ");
            }
        return stringRetorno;
    }

    public static String trocaAspasDuplasPorSimples(String string)
    {
        String stringRetorno = string;
        return stringRetorno.replaceAll("\"", "\'");

    }

    public static String nomeClasse(Object o)
    {
        String s = "";
        if (o != null)
        {
            s = o.getClass().getSimpleName();
            s = s.substring(0, 1).toLowerCase() + s.substring(1, s.length());
        }
        return s;
    }
}
