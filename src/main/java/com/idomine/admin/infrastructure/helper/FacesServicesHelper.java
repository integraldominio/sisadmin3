package com.idomine.admin.infrastructure.helper;

 
import static com.idomine.admin.infrastructure.helper.ExpressaoLogicaHelper.naoNulo;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.component.ContextCallback;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.text.StrBuilder;
import org.primefaces.context.RequestContext;

public final class FacesServicesHelper
{
    private FacesServicesHelper()
    {
    }

    public static void mensagem(String msg)
    {
        FacesMessage m = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage(null, m);
    }

    public static void atualizarElemento(String nome)
    {
        if (doFind(nome))
        {
            RequestContext.getCurrentInstance().update(nome);
        }
    }

    private static boolean found;

    public static boolean doFind(String clientId)
    {
        found = false;
        FacesContext
                .getCurrentInstance()
                .getViewRoot()
                .invokeOnComponent(FacesContext.getCurrentInstance(), clientId,
                        new ContextCallback()
                        {
                            public void invokeContextCallback(FacesContext context,
                                    UIComponent component)
                            {
                                found = true;
                            }
                        });
        return found;
    }

    public static void atualizarElementos(String... nomes)
    {
        for (int i = 0; i < nomes.length; i++)
            atualizarElemento(nomes[i]);
    }

    /**
     * Si el elemento a recibir focus esta dentro de un tab este será seleccionado antes del elemento
     */
    public static void receberFoco(String elementoId)
    {
        if (naoNulo(elementoId))
        {
            StrBuilder script = new StrBuilder();
            script.append("    var tabPanel = $('.ui-tabs-panel:has('+PrimeFaces.escapeClientId(':id')+')'); \n");
            script.append("    if(tabPanel.length > 0){ \n");
            script.append("        var tabPanelIndex = tabPanel.index() \n");
            script.append("        , tabViewId = $(tabPanel).parents('.ui-tabs')[0].id \n");
            script.append("        , tabViewWigetVar = getWidgetVarById(tabViewId); \n");
            script.append("        if($(tabPanel).attr('aria-hidden') == 'true'){ \n");
            script.append("            updatePrimefacesEl(tabViewId); \n");
            script.append("        } \n");
            script.append("        let silent = true; \n");
            script.append("        tabViewWigetVar.select(tabPanelIndex, silent); \n");
            script.append("    } \n");
            script.append(
                    "    var tabWizard = tabPanel.length == 0 ? $('.wizard-panel:has('+PrimeFaces.escapeClientId(':id')+')') : undefined; \n");
            script.append("    if(tabWizard != undefined && tabWizard.length > 0){ \n");
            script.append("        var wizardIndex = $('.wizard-panel').index(tabWizard) \n");
            script.append("        ,wizardButton = $('.wizard-button:eq('+wizardIndex+')'); \n");
            script.append("        if(!$(wizardButton).hasClass('clicado')){ \n");
            script.append("            $(wizardButton).click(); \n");
            script.append("        } \n");
            script.append("    } \n");
            script.append("    setTimeout(function(){focusEl(':id')},100); \n");
            script.replaceAll(":id", elementoId);
            RequestContext.getCurrentInstance().execute(script.toString());
        }
    }

    public static void esconderBarraProgresso()
    {
        RequestContext.getCurrentInstance().execute("PF('statusDialog').hide()");
    }

    public static void clicarBotaoMais()
    {
        RequestContext.getCurrentInstance().execute("$('.ui-stack .botao-mais-abre').click()");
    }

    public static void abrirDialogo(String nome)
    {
        RequestContext.getCurrentInstance().execute("PF('" + nome + "').show()");

    }
  
    public static void execute(String javaScript)
    {
        RequestContext.getCurrentInstance().execute(javaScript);
    }

    public static void executeSe(boolean condicao, String javaScript)
    {
        if (condicao)
        {
            RequestContext.getCurrentInstance().execute(javaScript);
        }
    }

    public static void fecharDialogo(String nome)
    {
        RequestContext.getCurrentInstance().execute("PF('" + nome + "').hide()");
    }

    public static void abrirDialogoImpressao()
    {
        RequestContext.getCurrentInstance().execute("PF('dialogoImpressao').show()");
    }

    public static void fecharDialogoImpressao()
    {
        RequestContext.getCurrentInstance().execute("PF('dialogoImpressao').hide()");
    }

    public static void fecharDialogo(Object dialogo)
    {
        RequestContext.getCurrentInstance().closeDialog(dialogo);
    }

    public static void redirecionar(String pagina)
    {
        try
        {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath() + StringsHelper.ajustarBarraSeparadora(pagina));
        }
        catch (IOException e)
        {
        }
    }
    public static void redirecionarURL(String pagina)
    {
        try
        {
            FacesContext.getCurrentInstance().getExternalContext()
            .redirect(pagina);
        }
        catch (IOException e)
        {
        }
    }

    public static Object recuperarObjetoRemovendoDaSessao(String nome)
    {
        Object retorno = SessionContextHelper.getInstance().getAttribute(nome);
        deletarObjetoDaSessao(nome);
        return retorno;
    }

    public static Object lerObjetoDaSessao(String nome)
    {
        return SessionContextHelper.getInstance().getAttribute(nome);
    }

    public static void deletarObjetoDaSessao(String nome)
    {
        SessionContextHelper.getInstance().removeAttribute(nome);
    }

    public static void salvarObjetoNaSessao(Object objeto, String nome)
    {
        SessionContextHelper.getInstance().setAttribute(nome, objeto);
    }

    public static void ajustarSessaoTimeOut(int tempoMinutos)
    {
        SessionContextHelper.getInstance().ajustarSessaoTimeOut(tempoMinutos);
    }

    public static void posicionarNaAbaMercadorias()
    {
        RequestContext.getCurrentInstance().execute("posicionaNaAbaMercadorias();");
    };

    public static void erroValidacao(String mensagemErro)
    {
        FacesMessagesHelper.erro(mensagemErro);
        FacesContext.getCurrentInstance().validationFailed();
    }

    public static void validarSe(boolean condicao, String mensagemErro)
    {
        if ((!condicao))
        {
            FacesMessagesHelper.erro(mensagemErro);
            FacesContext.getCurrentInstance().validationFailed();
        }
    }

    public static void validacaoFalhou()
    {
        FacesContext.getCurrentInstance().validationFailed();
    }

    public static String urlAtual()
    {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestServletPath();
    }

    public static boolean urlAtualContem(String textoContidoNaUrl)
    {
        return urlAtual().indexOf(textoContidoNaUrl) != -1;
    }

    public static boolean urlAtualNaoContem(String textoContidoNaUrl)
    {
        return !urlAtualContem(textoContidoNaUrl);
    }

    public static String ipMaquinaCliente()
    {
        return FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
    }

    private static final String[] IP_HEADER_CANDIDATES = {
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "REMOTE_ADDR" };

    public static String getClientIpAddress()
    {

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
                .getRequest();

        for (String header : IP_HEADER_CANDIDATES)
        {
            String ip = request.getHeader(header);
            if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip))
            {
                return ip;
            }
        }
        return request.getRemoteAddr();
    }

}
