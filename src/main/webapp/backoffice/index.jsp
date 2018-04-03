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
	<c:forEach items="${materiales}" var="material">
		<li>
		<!-- Choose es la alternativa a if cuando estos son muy complicados ya que no hay else -->
			<c:choose>
				<c:when test="${material.precio >= 6.0 && material.precio<=24.0  }">
					<p class="text-primary">(${material.id})${material.nombre} - ${material.precio}&euro;</p>
				</c:when>
				<c:when test="${material.precio >= 25.0 }">
					<p class="text-danger">(${material.id})${material.nombre} - ${material.precio}&euro;</p>
				</c:when>
				<c:otherwise>
		            (${material.id})${material.nombre} - ${material.precio}&euro;
		        </c:otherwise>
			</c:choose>
			
		</li>
	</c:forEach>
</ol>




<%@include file="/templates/footer.jsp"%>