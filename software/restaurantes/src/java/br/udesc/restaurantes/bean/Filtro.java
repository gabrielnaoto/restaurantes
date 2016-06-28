package br.udesc.restaurantes.bean;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(servletNames = {"Faces Servlet"})
public class Filtro implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest requisicao = (HttpServletRequest) request;
        HttpSession session = requisicao.getSession();
        if (session.getAttribute("user") == null) {
            if((requisicao.getRequestURI().endsWith("index.jsf"))
                || (requisicao.getRequestURI().endsWith("consultarestaurante.jsf"))
                || (requisicao.getRequestURI().endsWith("cadastrousuario.jsf"))
                || (requisicao.getRequestURI().contains("javax.faces.resource/"))){
                chain.doFilter(request, response);
            }
            else{
                redireciona("index.jsf", response);
            }
        }
        else{
            if((requisicao.getRequestURI().endsWith("cadastrousuario.jsf"))){
                redireciona("index.jsf", response);
            }
            else{
                chain.doFilter(request, response);
            }
        }
    }

    private void redireciona(String url, ServletResponse response) throws IOException {
        HttpServletResponse res = (HttpServletResponse) response;
        res.sendRedirect(url);
    }

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void destroy() {
    }
}
