<%@page import="com.ipartek.formacion.nidea.controller.backoffice.UsuarioController"%>
<%@page import="com.ipartek.formacion.nidea.controller.MaterialesController"%>
<%@page import="com.ipartek.formacion.nidea.controller.backoffice.MaterialController"%>
<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>
<div class="container">
	<div class="form-group row">
		<a class="btn btn-outline-dark btn-lg" href="backoffice/materiales">Volver</a>
	</div>
	<form action="backoffice/materiales" method="post">
	  <div class="form-group row">
	    <label for="id" class="col-sm-2 col-form-label">ID:</label>
	    <div class="col-sm-2">
	      <input type="text" class="form-control" name="id" readonly value="${usuario.id}">
	    </div>
	  </div>
	  <div class="form-group row">
	    <label for="nombre" class="col-sm-2 col-form-label">Usuario</label>
	    <div class="col-sm-5">
	      <input type="text"   autofocus class="form-control" name="nombre" placeholder="Introduce el nombre del usuario" value="${usuario.nombre}">
	    </div>
	  </div>
	  <div class="input-group ">
	    <label for="password" class="col-sm-2 col-form-label">Contraseña</label>
	    <div class="input-group-append">
	      <input type="text" class="form-control" name="password" placeholder="Introduce la contraseña" value="${usuario.password }">
	      <span class="input-group-text">&euro;</span>
	    </div>
	  </div>
	</div>
	<br> 
	<c:if test="${usuario.id == -1}"> 
		<div class="form-group row">
			 <div class="col-sm-12">
			 <input type="hidden" name="op" value="<%=UsuarioController.OP_GUARDAR%>">
			    <button type="submit" class="btn btn-primary btn-lg btn-block">Crear</button>
			  </div>
		</div>
	  </c:if>
	  <c:if test="${usuairo.id > -1 }">
		  <div class="form-group row">
		  	<div class="col-sm-6">
			    <input type="hidden" name="op" value="<%=UsuarioController.OP_GUARDAR%>">
			    <button type="submit" class="btn btn-success btn-lg btn-block" >Modificar</button>
			 </div>
			 <div class="col-sm-6">
				<!-- Button trigger modal -->
				<button type="button" class="btn btn-danger btn-lg btn-block" data-toggle="modal" data-target="#botonModal">
				 Eliminar
				</button>
				
				<!-- Modal -->
				<div class="modal fade" id="botonModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				      	<h5 class="modal-title" id="exampleModalLabel">Confirmacion de eliminacion del Usuario</h5>
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          <span aria-hidden="true">&times;</span>
				        </button>
				      </div>
				      <div class="modal-body">
				       ¿Deseas eliminar el usuario seleccionado?
				      </div>
				      <div class="modal-footer">
				        <a href="backoffice/materiales?id=${usuario.id}&op=<%=UsuarioController.OP_ELIMINAR%>" 
			       class="btn btn-danger">Eliminar</a>
				      </div>
				    </div>
				  </div>
				</div>
			 </div>
		  </div>
	   </c:if>
	</form>
</div>


<%@include file="/templates/footer.jsp"%>
