<%@page import="com.ipartek.formacion.nidea.controller.backoffice.RolController"%>
<%@page import="com.ipartek.formacion.nidea.controller.MaterialesController"%>
<%@page import="com.ipartek.formacion.nidea.controller.backoffice.MaterialController"%>
<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>



<h1>Roles de los usuarios</h1>

<form action="backoffice/rol" method="post" class="row">
	<div class=" input-group">
		<input type="hidden" name="op" value="<%=RolController.OP_BUSQUEDA%>">
		<input  type="text"class="form-control " name="search" required placeholder="Nombre del rol">
		<input type="submit"  value="Buscar">
	</div>
</form>

<a class="btn btn-outline-dark btn-lg float-right " href="backoffice/rol?op=<%=RolController.OP_MOSTRAR_FORMULARIO%>">Nuevo Rol</a>
<br>

<!-- DataTable -->
<table id="example" class="display table" cellspacing="0" width="100%">
  <thead>
    <tr>
      <!--<th scope="col">Id</th>  -->
      <th scope="col">Usuario</th>
      <th scope="col">Password</th>
    </tr>
  </thead>
  <tbody>
    
    <c:forEach  items="${rol}" var="rol">
    	<tr>
    		<td>${rol.id}</td>
    		<td><a href="backoffice/rol?id=${rol.id}&op=<%=RolController.OP_MOSTRAR_FORMULARIO%>">${rol.nombre}</a></td>
			
		</tr>
    </c:forEach>
   </tbody>
</table>

<!-- Fin dataTable -->

<%@include file="/templates/footer.jsp"%>