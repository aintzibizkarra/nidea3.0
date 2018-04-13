<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

<script>
	setTimeout(function () {
	   location.reload();
	   5000
		};
</script>
<h1>Lista de usuarios conectados</h1>

<!-- applicationScope(JSP)==ServletContext(Servlet) -->

<!--para mostrar datos del contexto  ${applicationScope.usuarios_conenctados}-->

<ul>
	<c:forEach items="${applicationScope.usuarios_conenctados}" var="usuario">
		<li>${usuario.key} -${usuario.value}</li>	
	</c:forEach>
</ul>

<jsp:include page="/templates/footer.jsp"></jsp:include>