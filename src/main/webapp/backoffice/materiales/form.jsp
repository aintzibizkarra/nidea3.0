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
	      <input type="text" class="form-control" name="id" readonly value="${material.id}">
	    </div>
	  </div>
	  <div class="form-group row">
	    <label for="nombre" class="col-sm-2 col-form-label">Material</label>
	    <div class="col-sm-5">
	      <input type="text"   autofocus class="form-control" name="nombre" placeholder="Introduce el nombre del material" value="${material.nombre}">
	    </div>
	  </div>
	  <div class="input-group ">
	    <label for="precio" class="col-sm-2 col-form-label">Precio</label>
	    <div class="input-group-append">
	      <input type="text" class="form-control" name="precio" placeholder="Introduce el precio" value="${material.precio }">
	      <span class="input-group-text">&euro;</span>
	    </div>
	  </div>
	</div>
	<br> 
	<c:if test="${material.id == -1}"> 
		<div class="form-group row">
			 <div class="col-sm-12">
			 <input type="hidden" name="op" value="<%=MaterialController.OP_GUARDAR%>">
			    <button type="submit" class="btn btn-primary btn-lg btn-block">Crear</button>
			  </div>
		</div>
	  </c:if>
	  <c:if test="${material.id > -1 }">
		  <div class="form-group row">
		  	<div class="col-sm-6">
			    <input type="hidden" name="op" value="<%=MaterialController.OP_GUARDAR%>">
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
				      	<h5 class="modal-title" id="exampleModalLabel">Confirmacion de eliminacion de Material</h5>
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          <span aria-hidden="true">&times;</span>
				        </button>
				      </div>
				      <div class="modal-body">
				       ¿Deseas eliminar el material seleccionado?
				      </div>
				      <div class="modal-footer">
				        <a href="backoffice/materiales?id=${material.id}&op=<%=MaterialController.OP_ELIMINAR%>" 
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
