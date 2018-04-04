<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>
<div class="form-group row">
	<a class="btn btn-outline-dark btn-lg" href="backoffice/materiales">Volver</a>
</div>
<form action="" method="post">
  <div class="form-group row">
    <label for="id" class="col-sm-2 col-form-label">ID:</label>
    <div class="col-sm-2">
      <input type="text" class="form-control" id="id" readonly>
    </div>
  </div>
  <div class="form-group row">
    <label for="nombre" class="col-sm-2 col-form-label">Material</label>
    <div class="col-sm-5">
      <input type="text" class="form-control" id="nombre" placeholder="Introduce el nombre del material">
    </div>
  </div>
  <div class="form-group row">
    <label for="precio" class="col-sm-2 col-form-label">Precio</label>
    <div class="col-sm-2">
      <input type="text" class="form-control" id="precio" placeholder="Introduce el precio del material">
    </div>
   
  </div>
  

  <div class="form-group row">
    <div class="col-sm-12">
      <button type="submit" class="btn btn-primary btn-lg btn-block">Crear</button>
    </div>
  </div>
  <div class="form-group row">
    <div class="col-sm-6">
      <button type="submit" class="btn btn-success btn-lg btn-block">Modificar</button>
    </div>
    <div class="col-sm-6">
      <button type="submit" class="btn btn-danger btn-lg btn-block">Eliminar</button>
    </div>
  </div>
</form>