
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
<title>Lista de Clientes</title>
</head>
<body>
<h1>Lista de Clientes</h1>
<br>
<br>
<a href="cliente?mod=cad">Cadastrar Novo Cliente</a>
<br>
<form action="pesquisarCliente" method="post">
<table>
<tr>
<td>Pesquisar:</td>
</tr>
<tr>
<td>CPF: </td>
<td>Nome: </td>
</tr>
<tr>
<td><input type="text" name="cpfin" size="50"></td>
<td><input type="text" name="namein" size="80"></td>
</tr>
<tr>
<td><input type="submit" name="btnpesquisar" value="Pesquisar"/></td>

</table>
</form>
<br>
<br>
<br>
<br>

<table id="tablegrid">
<tr>
<td>Selecionar</td>
<td>Nome: </td>
<td>CPF: </td>
<td></td>
<td></td>
</tr>
<c:forEach var="cliente" itens="clientes">
<tr>
<td><input type="checkbox" name="chkexc" value=0></td>
<td>${cliente.getNome}</td>
<td>${cliente.getCpf}</td>
<td><a href="ObterClienteServlet?id=${cliente.getId}">Alterar</a>
<td><a href="ExcluirClienteServlet?id=${cliente.getId}">Excluir</a>
</td>
</c:forEach>
</table>
<input type="button" name="btnExcBlock" value="Excluir Selecionados" onclick="ExluirBloco"/>
</body>
</html>