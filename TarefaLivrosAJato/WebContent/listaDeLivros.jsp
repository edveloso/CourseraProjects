<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Coursera - Esse eu j� li!</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">

<style>

.button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 16px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
}

.button1 {
    background-color: white; 
    color: black; 
    border: 2px solid #4CAF50;
}

.button1:hover {
    background-color: #4CAF50;
    color: white;
}

.button3 {
	padding: 3px 16px;
    background-color: white; 
    color: black; 
    border: 2px solid #f44336;
}

.button3:hover {
    background-color: #f44336;
    color: white;
}

</style>

<body>
	<div class="w3-container">

			<form method="post" action="logOut" style="float: right;">
				<p>Ol� ${nomeUsuario}</p>
				<button class="button button3" >sair</button>
			</form>

			<form method="get" action="ranking">
				<button class="button button1">Vizualizar Ranking de Usu�rios</button>
			</form>

		<div class="w3-container">
			<h2>Lista de Livros</h2>
	
			
			<table class="w3-table-all">
				<thead>
					<tr class="w3-green">
						<th>T�tulo do Livro</th>
						<th>Estilo</th>
						<th>Quantidade de P�ginas</th>
					</tr>
				</thead>
				<c:forEach var="livro" items="${livros}">
					<tr class="w3-hover-gray" >
						<td id="titulo">
							<a href="visualizarLivro?id=${livro.id}">${livro.titulo}</a>
						</td>
						<td id="paginas">${livro.estilo.estilo}</td>
						<td id="paginas">${livro.qtdPaginas}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
