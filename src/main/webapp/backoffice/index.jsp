<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>


<h1>Backoffice</h1>

<%
	//ArrayList <Materiales> lista = (ArrayList <Materiales>) request.getAttribute("materiales"); 
	//A PARTIR DE AHORA MEJOR UTILIZAMOS EL =>EXPRESION LENGUAGE ${}
	//Podemos usar cualquier exprecion, si no hay exprecion pinta la variable

%>
<div class="text-center">
  <a href="material"><img src="img/materiales.jpg" class="rounded" alt="materiales"></a>
</div>

<ul>
	<c:forEach items="${applicationScope.usuarios_conenctados}" var="usuario">
		<li>${usuario.key} -${usuario.value}</li>	
	</c:forEach>
</ul>


<%@include file="/templates/footer.jsp"%>