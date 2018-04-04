<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>



<h1>(Backoffice)Lista de Materiales</h1>

<%
	//ArrayList <Materiales> lista = (ArrayList <Materiales>) request.getAttribute("materiales"); 
	//A PARTIR DE AHORA MEJOR UTILIZAMOS EL =>EXPRESION LENGUAGE ${}
	//Podemos usar cualquier exprecion, si no hay exprecion pinta la variable

%>


<form action="backoffice/materiales" method="get">
	<input  type="text" name="search" required placeholder="Nombre del material">
	<input type="submit" value="Buscar">
</form>

<div class="form-group row">
	<a class="btn btn-outline-dark btn-lg pull-right" href="backoffice/materiales/form.jsp">Añadir Nuevo Material</a>
</div>

<table id="example" class="display table" cellspacing="0" width="100%">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Material</th>
      <th scope="col">Precio</th>
    </tr>
  </thead>
  <tbody>
    
    <c:forEach  items="${material}" var="material">
    	<tr>
    	<c:choose>
			<c:when test="${material.precio >= 25}">
				<td class="text-danger">${material.id}</td>
				<td class="text-danger">${material.nombre}</td>
				<td class="text-danger">${material.precio}&euro;</td>
				
			</c:when>
			<c:when test="${material.precio >= 6}">
				<td class="text-primary">${material.id}</td>
				<td class="text-primary">${material.nombre}</td>
				<td class="text-primary">${material.precio}&euro;</td>
				
			</c:when>
			<c:otherwise>
		          <td>${material.id}</td>
				<td>${material.nombre}</td>
				<td>${material.precio}&euro;</td>
				
		    </c:otherwise>
		</c:choose>	
		</tr>
    </c:forEach>
   
  </tbody>
</table>





<%@include file="/templates/footer.jsp"%>