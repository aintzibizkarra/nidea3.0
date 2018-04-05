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
	      <input type="text" class="form-control" name="nombre" placeholder="Introduce el nombre del material" value="${material.nombre}">
	    </div>
	  </div>
	  <div class="input-group ">
	    <label for="precio" class="col-sm-2 col-form-label">Precio</label>
	    <div class="input-group-append">
	      <input type="text" class="form-control" name="precio" placeholder="Introduce el precio" value="">
	      <span class="input-group-text">&euro;</span>
	    </div>
	  </div>
	</div>
	<br>  
	<div class="form-group row">
	    <div class="col-sm-12">
	    		<a class="btn btn-primary btn-lg btn-block" href="backoffice/materiales?id=${material.id}&op=<%=MaterialController.OP_GUARDAR%>">Crear</a>
	    </div>
	  </div>
	  <div class="form-group row">
	    <div class="col-sm-6">
	    	<a class="btn btn-success btn-lg btn-block" href="backoffice/materiales?id=${material.id}&op=<%=MaterialController.OP_GUARDAR%>">Modificar</a>
	    </div>
	    <div class="col-sm-6">
	    	<a class="btn btn-danger btn-lg btn-block" href="backoffice/materiales?id=${material.id}&op=<%=MaterialController.OP_ELIMINAR%>">Eliminar</a>
	    </div>
	  </div>
	</form>
</div>