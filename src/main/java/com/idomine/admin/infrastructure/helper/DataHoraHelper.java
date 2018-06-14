package com.idomine.admin.infrastructure.helper;

 import static com.idomine.admin.infrastructure.helper.ExpressaoLogicaHelper.naoNulo;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

public final class DataHoraHelper
{

    private DataHoraHelper()
    {
    }

    public static Date dataComHoraInicial(Date dataInicial)
    {
        if (naoNulo(dataInicial))
        {

            Calendar dataInicioFiltro = Calendar.getInstance();
            dataInicioFiltro.setTime(dataInicial);
            dataInicioFiltro.set(Calendar.HOUR_OF_DAY, 0);
            dataInicioFiltro.set(Calendar.MINUTE, 0);
            dataInicioFiltro.set(Calendar.SECOND, 0);
            return dataInicioFiltro.getTime();
        }
        return null;
    }

    public static Date dataComHoraFinal(Date dataFinal)
    {
        if (naoNulo(dataFinal))
        {
            Calendar dataFinalFiltro = Calendar.getInstance();
            dataFinalFiltro.setTime(dataFinal);
            dataFinalFiltro.set(Calendar.HOUR_OF_DAY, 23);
            dataFinalFiltro.set(Calendar.MINUTE, 59);
            dataFinalFiltro.set(Calendar.SECOND, 59);
            return dataFinalFiltro.getTime();
        }
        return null;
    }

    public static List<Date> periodo(Date dataInicial, Date dataFinal)
    {
        if (naoNulo(dataInicial) && naoNulo(dataFinal))
        {
            return Arrays.asList(dataComHoraInicial(dataInicial), dataComHoraFinal(dataFinal));
        }
        return null;
    }

    public static Date dataInicioDeAno(Date dataInicial)
    {
        if (naoNulo(dataInicial))
        {
            Calendar dataInicioFiltro = Calendar.getInstance();
            dataInicioFiltro.setTime(dataInicial);
            dataInicioFiltro.set(Calendar.HOUR_OF_DAY, 0);
            dataInicioFiltro.set(Calendar.MINUTE, 0);
            dataInicioFiltro.set(Calendar.SECOND, 0);
            dataInicioFiltro.set(Calendar.DAY_OF_MONTH, 1);
            dataInicioFiltro.set(Calendar.MONTH, 0);
            return dataInicioFiltro.getTime();
        }
        return null;
    }

    public static Date primeiroDiaDoAno(Date data)
    {
        int ano = ano(data);

        return new DateTime()
                .withDayOfMonth(1)
                .withMonthOfYear(1)
                .withYear(ano)
                .withTime(0, 0, 0, 0)
                .toDate();

    }

    public static Date ultimoDiaDoAno(Date data)
    {
        int ano = ano(data);

        return new DateTime()
                .withDayOfMonth(31)
                .withMonthOfYear(12)
                .withYear(ano)
                .withTime(23, 59, 59, 0)
                .toDate();

    }

    public static Date primeiroDiaDoMes(Date data)
    {
        int mes = mes(data);
        int ano = ano(data);

        return new DateTime()
                .withDayOfMonth(1)
                .withMonthOfYear(mes)
                .withYear(ano)
                .withTime(0, 0, 0, 0)
                .toDate();
    }

    public static Date ultimoDiaDoMes(Date data)
    {
        int mes = mes(data);
        int ano = ano(data);

        return new DateTime()
                .dayOfMonth().withMaximumValue()
                .withMonthOfYear(mes)
                .withYear(ano)
                .withTime(23, 59, 59, 0)
                .toDate();
    }

    public static Date hoje()
    {
        return new DateTime().withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0).toDate();
    }

    public static Date inicioDoDia(Date data)
    {
        if (data != null)
        {

            int dia = dia(data);
            int mes = mes(data);
            int ano = ano(data);

            return new DateTime()
                    .withDayOfMonth(dia)
                    .withMonthOfYear(mes)
                    .withYear(ano)
                    .withTime(0, 0, 0, 0)
                    .toDate();
        }
        return null;
    }

    public static Date fimDoDia(Date data)
    {
        if (data != null)
        {
            int dia = dia(data);
            int mes = mes(data);
            int ano = ano(data);

            return new DateTime()
                    .withDayOfMonth(dia)
                    .withMonthOfYear(mes)
                    .withYear(ano)
                    .withTime(23, 59, 59, 0)
                    .toDate();
        }
        return null;
    }

    public static Date primeiroDiaDaSemana(Date data)
    {
        int mes = mes(data);
        int ano = ano(data);

        return new DateTime()
                .withDayOfWeek(1)
                .withMonthOfYear(mes)
                .withYear(ano)
                .withTime(0, 0, 0, 0)
                .toDate();
    }

    public static Date ultimoDiaDaSemana(Date data)
    {
        int mes = mes(data);
        int ano = ano(data);

        return new DateTime()
                .withDayOfWeek(7)
                .withMonthOfYear(mes)
                .withYear(ano)
                .withTime(23, 59, 59, 0)
                .toDate();
    }

    public static Date primeiroDiaDoSemestre(Date data)
    {
        int mes = mes(data);
        int ano = ano(data);
        int primeiroMesSemestre;
        if (mes <= 6)
            primeiroMesSemestre = 1;
        else
            primeiroMesSemestre = 7;

        return new DateTime()
                .withDayOfMonth(1)
                .withMonthOfYear(primeiroMesSemestre)
                .withYear(ano)
                .withTime(0, 0, 0, 0)
                .toDate();
    }

    public static Date ultimoDiaDoSemestre(Date data)
    {
        int mes = mes(data);
        int ano = ano(data);
        int ultimoMesSemestre;
        if (mes <= 6)
            ultimoMesSemestre = 6;
        else
            ultimoMesSemestre = 12;

        return new DateTime()
                .dayOfMonth().withMaximumValue()
                .withMonthOfYear(ultimoMesSemestre)
                .withYear(ano)
                .withTime(23, 59, 59, 0)
                .toDate();
    }

    public static Date primeiroDiaDoBimestre(Date data)
    {
        int mes = mes(data);
        int ano = ano(data);
        int primeiroMesBimestre;
        if (mes <= 2)
            primeiroMesBimestre = 1;
        if (mes > 2 && mes <= 4)
            primeiroMesBimestre = 3;
        if (mes > 4 && mes <= 6)
            primeiroMesBimestre = 5;
        if (mes > 6 && mes <= 8)
            primeiroMesBimestre = 7;
        if (mes > 8 && mes <= 10)
            primeiroMesBimestre = 9;
        else
            primeiroMesBimestre = 11;

        return new DateTime()
                .withDayOfMonth(1)
                .withMonthOfYear(primeiroMesBimestre)
                .withYear(ano)
                .withTime(0, 0, 0, 0)
                .toDate();
    }

    public static Date ultimoDiaDoBimestre(Date data)
    {
        int mes = mes(data);
        int ano = ano(data);
        int ultimoMesBimestre;
        if (mes <= 2)
            ultimoMesBimestre = 2;
        if (mes > 2 && mes <= 4)
            ultimoMesBimestre = 4;
        if (mes > 4 && mes <= 6)
            ultimoMesBimestre = 6;
        if (mes > 6 && mes <= 8)
            ultimoMesBimestre = 8;
        if (mes > 8 && mes <= 10)
            ultimoMesBimestre = 10;
        else
            ultimoMesBimestre = 12;

        return new DateTime()
                .dayOfMonth().withMaximumValue()
                .withMonthOfYear(ultimoMesBimestre)
                .withYear(ano)
                .withTime(23, 59, 59, 0)
                .toDate();
    }

    public static Date primeiroDiaDoTrimestre(Date data)
    {
        int mes = mes(data);
        int ano = ano(data);
        int primeiroMesTrimestre;
        if (mes <= 3)
            primeiroMesTrimestre = 1;
        if (mes > 3 && mes <= 6)
            primeiroMesTrimestre = 3;
        if (mes > 6 && mes <= 9)
            primeiroMesTrimestre = 6;
        else
            primeiroMesTrimestre = 9;

        return new DateTime()
                .withDayOfMonth(1)
                .withMonthOfYear(primeiroMesTrimestre)
                .withYear(ano)
                .withTime(0, 0, 0, 0)
                .toDate();
    }

    public static Date ultimoDiaDoTrimestre(Date data)
    {
        int mes = mes(data);
        int ano = ano(data);
        int ultimoMesTrimestre;
        if (mes <= 3)
            ultimoMesTrimestre = 3;
        if (mes > 3 && mes <= 6)
            ultimoMesTrimestre = 6;
        if (mes > 6 && mes <= 9)
            ultimoMesTrimestre = 9;
        else
            ultimoMesTrimestre = 12;

        return new DateTime()
                .dayOfMonth().withMaximumValue()
                .withMonthOfYear(ultimoMesTrimestre)
                .withYear(ano)
                .withTime(23, 59, 59, 0)
                .toDate();
    }

    public static Date primeiroDiaDaQuinzena(Date data)
    {
        int ano = ano(data);
        int mes = mes(data);
        int dia = dia(data);
        int primeiroDiaQuinzena;
        if (dia <= 15)
            primeiroDiaQuinzena = 1;
        else
            primeiroDiaQuinzena = 16;

        return new DateTime()
                .withDayOfMonth(primeiroDiaQuinzena)
                .withMonthOfYear(mes)
                .withYear(ano)
                .withTime(0, 0, 0, 0)
                .toDate();
    }

    public static Date ultimoDiaDaQuinzena(Date data)
    {
        int ano = ano(data);
        int mes = mes(data);
        int dia = dia(data);
        int ultimoDiaQuinzena;
        if (dia <= 15)
            ultimoDiaQuinzena = 15;
        else
        {
            Date ultimoDiaMes = ultimoDiaDoMes(data);
            Calendar cal = Calendar.getInstance();
            cal.setTime(ultimoDiaMes);
            ultimoDiaQuinzena = cal.get(Calendar.DAY_OF_MONTH);
        }

        return new DateTime()
                .withDayOfMonth(ultimoDiaQuinzena)
                .withMonthOfYear(mes)
                .withYear(ano)
                .withTime(23, 59, 59, 0)
                .toDate();
    }

    private static int ano(Date data)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        int mes = cal.get(Calendar.YEAR);
        return mes;
    }

    private static int mes(Date data)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        int mes = cal.get(Calendar.MONTH) + 1;
        return mes;
    }

    private static int dia(Date data)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        return dia;
    }
}
