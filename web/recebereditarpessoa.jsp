
<%@page import="Classes.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%
        int vidpessoa = Integer.parseInt(request.getParameter("idpessoa"));
        String vnomepessoa = request.getParameter("nomepessoa");
        String vemail  = request.getParameter("email");
        
        Pessoa p  = new Pessoa();
        p.setIdPessoa(vidpessoa);
        p.setNomePessoa(vnomepessoa);
        p.setEmail(vemail);
        
        if(p.alterarPessoa(p)){
            
            response.sendRedirect("consultrapessoa.jsp? mensagem= pessoa alterada com sucesso");
        }else{
            response.sendRedirect("consultrapessoa.jsp? mensagem= pessoa não alterada ");
        }
        
    %>