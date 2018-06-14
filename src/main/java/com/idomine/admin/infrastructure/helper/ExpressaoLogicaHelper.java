package com.idomine.admin.infrastructure.helper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;

import com.idomine.admin.infrastructure.exceptions.AtributoInexistenteException;
 

public final class ExpressaoLogicaHelper
{
    private ExpressaoLogicaHelper(){}
    
    // object

    public static boolean diferenteDeNulo(Object o)
    {
        return naoNulo(o);
    }

    public static boolean naoNulo(Object o)
    {
        return o != null;
    }

    public static boolean nulo(Object o)
    {
        return o == null;
    }
    
    public static boolean naoNuloENaoVazio(List<?> o)
    {
        return naoNulo(o) && !o.isEmpty();
    }

    // Long
    public static boolean iguais(long numeroIni, long numeroFim)
    {
        return numeroIni==numeroFim;
    }
    
    public static boolean iguais(Long numeroIni, Long numeroFim)
    {
        return numeroIni.equals(numeroFim);
    }

    public static boolean diferente(Long numeroIni, Long numeroFim)
    {
        return ! iguais(numeroIni,numeroFim);
    }

    public static boolean igualZero(Long numero)
    {
        return numero.doubleValue() == 0;
    }

    public static boolean igualAZero(long numero)
    {
        return numero == 0;
    }

    public static boolean maiorQueZero(Long numero)
    {
        return numero > 0;
    }

    public static boolean menorQueZero(Long numero)
    {
        return numero < 0;
    }

    public static boolean menorOuIgualZero(Long numero)
    {
        return numero <= 0;
    }

    // BigDecimal

    public static boolean diferentes( BigDecimal primeiroNumero, BigDecimal segundoNumero)
    {
        return !iguais(primeiroNumero,segundoNumero);
    }
    
    public static boolean iguais(BigDecimal primeiroNumero, BigDecimal segundoNumero)
    {
        return (naoNulo(primeiroNumero) && naoNulo(segundoNumero) && (primeiroNumero.compareTo(segundoNumero) == 0));
    }

    public static boolean iguais(BigDecimal primeiroNumero, Long segundoNumero)
    {
        return (naoNulo(primeiroNumero) && naoNulo(segundoNumero)
                && (primeiroNumero.compareTo(new BigDecimal(segundoNumero)) == 0));
    }

    public static boolean igualZero(BigDecimal numero)
    {
        return (numero != null) && (numero.doubleValue() == 0);
    }

    public static boolean maiorQueZero(BigDecimal numero)
    {
        return (numero != null) && (numero.doubleValue() > 0);
    }

    public static boolean maiorOuIgualZero(BigDecimal numero)
    {
        return (numero != null) && (numero.doubleValue() >= 0);
    }

    public static boolean maiorOuIgualZero(Long numero)
    {
        return (numero != null) && (numero.doubleValue() >= 0);
    }

    public static boolean menorQueZero(BigDecimal numero)
    {
        return (numero != null) && (numero.doubleValue() < 0);
    }

    public static boolean menorOuIgualZero(BigDecimal numero)
    {
        return (numero != null) && (numero.doubleValue() <= 0);
    }

    public static boolean menorOuIgualAZero(BigDecimal numero)
    {
        return (numero != null) && (numero.doubleValue() <= 0);
    }

    public static boolean menorOuIgualAZero(Long numero)
    {
        return (numero != null) && (numero.doubleValue() <= 0);
    }

    public static boolean igual(BigDecimal valor1, BigDecimal valor2)
    {
        return (valor1 != null) && (valor2 != null) && (valor1.compareTo(valor2) == 0);
    }

    public static boolean maiorQue(BigDecimal valor1, BigDecimal valor2)
    {
        return (valor1 != null) && (valor2 != null) && (valor1.compareTo(valor2) == 1);
    }

    public static boolean maiorOuIgualQue(BigDecimal valor1, BigDecimal valor2)
    {
        return (valor1 != null) && (valor2 != null) && (valor1.compareTo(valor2) >= 0);
    }

    public static boolean menorQue(BigDecimal valor1, BigDecimal valor2)
    {
        return (valor1 != null) && (valor2 != null) && (valor1.compareTo(valor2) == -1);
    }

    public static boolean menorOuIgualQue(BigDecimal valor1, BigDecimal valor2)
    {
        return (valor1 != null) && (valor2 != null) && (valor1.compareTo(valor2) <= 0);
    }

    public static boolean diferente(BigDecimal valor1, BigDecimal valor2)
    {
        return (valor1 != null) && (valor2 != null) && (valor1.compareTo(valor2) != 0);
    }

    // String

    public static boolean maiorQueVazio(String string)
    {
        return (string != null) &&  !"".equals(string.trim()); 
    }

    public static boolean igualVazio(String string)
    {
        return (string != null) && (string.trim().equals(""));
    }

    public static boolean naoNuloENaoVazio(String string)
    {
        return ! vazioOuNulo( string);
    }
    
    public static boolean vazioOuNulo(String string)
    {
        return (string == null) || (string.trim().equals(""));
    }
    
    
    
    public static boolean tamanhoStringEntre(String string, long minimo, long maximo )
    {
        String s = nulo( string ) ? "" :string.trim();
        return s.length()>=minimo && s.length()<=maximo;
    }

    // Date

    public static boolean maiorOuIgualQueHoje(Date data)
    {
        return (data != null) && (data.compareTo(new Date()) >= 0);
    }

    public static boolean maiorQueHoje(Date data)
    {
        return (data != null) && (data.compareTo(new Date()) > 0);
    }

    public static boolean igualAHoje(Date data)
    {
        return (data != null) && (data.compareTo(new Date()) == 0);
    }

    public static boolean maiorQue(Date primeiraData, Date segundaData)
    {
        return (primeiraData != null) && (segundaData != null)
                && (DateUtils.truncatedCompareTo(primeiraData, segundaData, Calendar.DAY_OF_MONTH) > 0);
    }
    
    public static boolean dataEHoraMaiorQue(Date primeiraData, Date segundaData)
    {
        return (primeiraData != null) && (segundaData != null)
                && (primeiraData.compareTo(segundaData) > 0);
    }

    public static boolean menorQue(Date primeiraData, Date segundaData)
    {
        return (primeiraData != null) && (segundaData != null)
                && (DateUtils.truncatedCompareTo(primeiraData, segundaData, Calendar.DAY_OF_MONTH) < 0);
    }

    public static boolean maiorOuIgualQue(Date primeiraData, Date segundaData)
    {
        return (primeiraData != null) && (segundaData != null)
                && (DateUtils.truncatedCompareTo(primeiraData, segundaData, Calendar.DAY_OF_MONTH) >= 0);
    }

    public static boolean menorOuIgualQue(Date primeiraData, Date segundaData)
    {
        return (primeiraData != null) && (segundaData != null)
                && (DateUtils.truncatedCompareTo(primeiraData, segundaData, Calendar.DAY_OF_MONTH) <= 0);
    }

    public static boolean igual(Date primeiraData, Date segundaData)
    {
        return (primeiraData != null) && (segundaData != null)
                && (DateUtils.truncatedCompareTo(primeiraData, segundaData, Calendar.DAY_OF_MONTH) == 0);
    }

    public static boolean diferente(Date primeiraData, Date segundaData)
    {
        return (primeiraData != null) && (segundaData != null)
                && (DateUtils.truncatedCompareTo(primeiraData, segundaData, Calendar.DAY_OF_MONTH) != 0);
    }

    public static boolean verificarAlgumNulo(Object objetoPesquisado, String listaObjetos)
    {
        verificarAtributoInvalido(objetoPesquisado, listaObjetos);

        Method[] methods = objetoPesquisado.getClass().getDeclaredMethods();
        for (Method method : methods)
        {
            if ((method.getName().startsWith("get") || method.getName().startsWith("is"))
                    && listaObjetos.toLowerCase().contains(method.getName().substring(3).toLowerCase()))
            {
                try
                {
                    Object o = method.invoke(objetoPesquisado);
                    if (o == null)
                    {
                        return true;
                    } 
                }
                catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
                {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return false;
    }

    public static boolean verificarAlgumNuloOuMenorIgualZero(Object objetoPesquisado, String listaObjetos)
    {
        verificarAtributoInvalido(objetoPesquisado, listaObjetos);

        Method[] methods = objetoPesquisado.getClass().getDeclaredMethods();
        for (Method method : methods)
        {
            if ((method.getName().startsWith("get") || method.getName().startsWith("is"))
                    && listaObjetos.toLowerCase().contains(method.getName().substring(3).toLowerCase()))
            {
                try
                {
                    Object o = method.invoke(objetoPesquisado);
                    if (o == null)
                    {
                        return true;
                    }
                    else if (o.getClass() == int.class || o.getClass() == long.class ||
                            o.getClass() == Long.class || o.getClass() == BigDecimal.class ||
                            o.getClass() == Double.class || o.getClass() == double.class ||
                            o.getClass() == BigInteger.class)
                    {
                        if (Double.valueOf(o.toString()) <= 0)
                        {
                            return true;
                        }
                    }

                }
                catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
                {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return false;
    }

    
    private static void verificarAtributoInvalido(Object objeto, String listaAtributos)
    {
        List<String> atributos = StringsHelper.stringToList(listaAtributos, "|");
        for (String atributo : atributos)
        {
            if (!atributoExistente(objeto, atributo))
            {
                ExceptionHelper.throwException(
                        new AtributoInexistenteException(
                                ">>>ExpressaoLogicaHelper.verificarAtributoInvalido: [ Atributo não existe ] :[ "
                                        + atributo + "]"));
            }
        }
    }

    private static boolean atributoExistente(Object objeto, String atributo)
    {
        try
        {
            objeto.getClass().getDeclaredField(atributo);
            return true;
        }
        catch (NoSuchFieldException | SecurityException e)
        {
            return false;
        }
    }

    public static BigDecimal converterPercentualAValor(BigDecimal percentual, BigDecimal valorTotal){
        BigDecimal retorno = BigDecimal.ZERO;
        if(naoNulo(percentual) && maiorQueZero(percentual) && naoNulo(valorTotal) && maiorQueZero(valorTotal)){
            retorno = valorTotal.multiply(percentual.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP));
        }
        return retorno;
    }
    
    public static BigDecimal converterValorAPercentual(BigDecimal valor, BigDecimal valorTotal){
        BigDecimal retorno = BigDecimal.ZERO;
        if(naoNulo(valor) && maiorQueZero(valor) && naoNulo(valorTotal) && maiorQueZero(valorTotal)){
            retorno = valor.multiply(new BigDecimal(100)).divide(valorTotal, 2, RoundingMode.HALF_UP);
        }
        return retorno;
    }
}
