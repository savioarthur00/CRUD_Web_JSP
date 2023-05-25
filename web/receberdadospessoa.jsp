<%@page import="Classes.Pessoa"%>




<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    
    
    String vnomepessoa = request.getParameter("nomepessoa");
    String vemail = request.getParameter("email");
    
    Pessoa p = new Pessoa();
     p.setNomePessoa(vnomepessoa);
    p.setEmail(vemail);
    
    if(p.incluirPessoa(p)){
        response.sendRedirect("cadastrarpessoa.jsp?pmensagem= Pessoa cadastrada com sucesso");
    }else{
        response.sendRedirect("cadastrarpessoa.jsp?pmensagem= Pessoa não cadastrada");
    }
    


%>