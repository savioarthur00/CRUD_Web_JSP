<%-- 
    Document   : editarpessoa
    Created on : 11 de mai. de 2023, 15:55:29
    Author     : Arthurcc
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Classes.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        </head>
    <body>
        <%
            int idPessoa  = Integer.parseInt(request.getParameter("idpessoa"));
                                  
             Pessoa c = new Pessoa();
             c.buscarPessoa(c.getIdPessoa());
             
        %>
            
        <div>
            <div class="container">
                <form id="pessoa" action="recebereditarpessoa.jsp" method="POST">
                    <h3>Alterar Pessoa</h3>
                    <p></p>
                    
                    <fieldset>
                        <div class="idcolaborador">
                            <label> Idpessoa </label>
                            <input type="text" name="idpessoa" readonly="true" value="<%out.write("" +c.getIdPessoa());%>" />
                            
                        </div>
                            
                    </fieldset>
                            
                            </fieldset>
                            <fieldset>
                        <div class="nomepessoa">
                            <label> Pessoa </label>
                            <input type="text" name="nomepessoa" required maxlength="40" value="<%out.write("" +c.getIdPessoa());%>" />
                            
                        </div>
                    </fieldset>        
                    </fieldset>
                            <fieldset>
                        <div class="email">
                            <label> Email </label>
                            <input type="text" name="email" required maxlength="50" value="<%out.write("" +c.getIdPessoa());%>" />
                            
                        </div>
                    
                        <div class="row">
                            <div class="form-group col-md-3 h-10">
                                
                                <input type="submit" values="Alterar" class="btn btn-primary"
                            </div>
                              
                            
                            <div class="form-group col-md-3 h-10">
                                <input type="submit" values="Cancelar" class="btn btn-primary"
                            </div>
                        </div>
                    
                    
                </form>
            </div>
            
            
        </div>
        
        
        
    </body>
</html>
