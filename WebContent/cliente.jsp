<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Cliente</h1>
<br>
<br>
<form action="ManterClinteServlet" method="post">
<table>
<tr hidden="true">
<td>ID: </td>
<td>${cliente.getId}</td>
</tr>
<tr>
<td>Nome: </td>
<td><input type="text" name="nome" value=${cliente.getNome} /></td>
</tr>
<tr>
<td>CPF: </td>
<td><input type="text" name="cpf" value=${cliente.getCpf} /></td>
</tr>
<tr>
<td>E-mail: </td>
<td><input type="text" name="email" value=${cliente.getEmail} /></td>
</tr>
<tr>
<td>Data Nascimento: </td>
<td><input type="text" name="datnasc" value=${cliente.getDatnasc} /></td>
</tr>
<tr>
<td>Estado Civil: </td>
<td><select name="estcivil">
<option value="solteiro">Solteiro</option>
<option value="casado">Casado</option>
<option value="divorciado">Divorciado</option>
<option value="viúvo">Viúvo</option>
</select></td>
</tr>
<tr>
<td>Sexo: </td>
<td><input type="radio" name="sexo" value="M" />Masculino<br>
<input type="radio" name="sexo" value="F" />Feminino
</td>
</tr>
<tr>
<td>Ativo: </td>
<td><input type="checkbox" name="ativo" value=${cliente.getAtivo} /></td>
</tr>
<tr>
<td><input type="submit" value="Cadastrar" /></td>
<td><input type="button" value="Cancelar" action="/ClienteGridServlet" /></td>
</tr>

</table>

</form>
</body>
</html>