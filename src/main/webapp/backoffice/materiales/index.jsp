<%@page import="com.ipartek.formacion.nidea.controller.MaterialesController"%>
<%@page import="com.ipartek.formacion.nidea.controller.backoffice.MaterialController"%>
<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>



<h1>(Backoffice)Lista de Materiales</h1>

<%
	//ArrayList <Materiales> lista = (ArrayList <Materiales>) request.getAttribute("materiales"); 
	//A PARTIR DE AHORA MEJOR UTILIZAMOS EL =>EXPRESION LENGUAGE ${}
	//Podemos usar cualquier exprecion, si no hay exprecion pinta la variable

%>


<form action="backoffice/materiales" method="post" class="row">
	<div class=" input-group">
		<input type="hidden" name="op" value="<%=MaterialController.OP_BUSQUEDA%>">
		<input  type="text"class="form-control " name="search" required placeholder="Nombre del material">
		<input type="submit"  value="Buscar">
	</div>
</form>
<a class="btn btn-outline-dark btn-lg float-right " href="backoffice/materiales?op=<%=MaterialController.OP_MOSTRAR_FORMULARIO%>">Añadir</a>
<br>
<!-- DataTable -->
<table id="example" class="display table" cellspacing="0" width="100%">
  <thead>
    <tr>
      <!--<th scope="col">Id</th>  -->
      <th scope="col">Material</th>
      <th scope="col">Precio</th>
    </tr>
  </thead>
  <tbody>
    
    <c:forEach  items="${materiales}" var="material">
    	<tr>
    	<c:choose>
			<c:when test="${material.precio >= 25}">
				<!-- <td>${material.id}</td> -->
				<td><a href="backoffice/materiales?id=${material.id}&op=<%=MaterialController.OP_MOSTRAR_FORMULARIO%>">${material.nombre}</a></td>
				<td class="text-danger">${material.precio}&euro;</td>
			</c:when>
			<c:when test="${material.precio >= 6}">
				<!-- <td>${material.id}</td> -->
				<td><a href="backoffice/materiales?id=${material.id}&op=<%=MaterialController.OP_MOSTRAR_FORMULARIO%>">${material.nombre}</a></td>
				<td class="text-primary">${material.precio}&euro;</td>
			</c:when>
			<c:otherwise>
		         <!-- <td>${material.id}</td> -->
				<td><a href="backoffice/materiales?id=${material.id}&op=<%=MaterialController.OP_MOSTRAR_FORMULARIO%>">${material.nombre}</a></td>
				<td>${material.precio}&euro;</td>
			</c:otherwise>
		</c:choose>	
		</tr>
    </c:forEach>
   </tbody>
</table>

<!-- Fin dataTable -->



<%@include file="/templates/footer.jsp"%>