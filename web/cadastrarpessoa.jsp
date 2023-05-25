<%@page import="Classes.Pessoa"%>

<html>
<head>
    <title>Cadastrar Pessoa</title>
</head>
<body>
    <h1>Cadastrar Pessoa</h1>
    <form method="post" action="receberdadospessoa.jsp">
        <label for="nomepessoa">Nome:</label>
        <input type="text" name="nomepessoa" id="nomepessoa">
        <br>
        <label for="email">Email:</label>
        <input type="text" name="email" id="email">
        <br>
        <input type="submit" value="Cadastrar">
    </form>
    <% if(request.getParameter("pmensagem")!=null){ %>
        <p><%=request.getParameter("pmensagem") %></p>
    <% } %>
</body>
</html>
