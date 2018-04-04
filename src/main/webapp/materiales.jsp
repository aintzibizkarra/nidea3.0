<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>
<h1>Lista de Materiales</h1>

<%
	//ArrayList <Materiales> lista = (ArrayList <Materiales>) request.getAttribute("materiales"); 
	//A PARTIR DE AHORA MEJOR UTILIZAMOS EL =>EXPRESION LENGUAGE ${}
	//Podemos usar cualquier exprecion, si no hay exprecion pinta la variable

%>
<ol>
	<c:forEach items="${material}" var="material">
		<c:set var="clase" value="" />	
		<c:choose>
			<c:when test="${material.precio >= 25}">
				<c:set var="clase" value="text-danger" />
			</c:when>
			<c:when test="${material.precio >= 6}">
				<c:set var="clase" value="text-primary" />
			</c:when>
		</c:choose>	
		<li>${material.nombre} - <span class="${clase}">${material.precio} &euro;</span></li>	
	</c:forEach>
</ol>




<%@include file="/templates/footer.jsp"%>