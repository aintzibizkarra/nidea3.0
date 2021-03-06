<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
	<a href="index.jsp">
		<img src="img/logo.png" class="logo" alt="Logo Nidea">
	</a>	
	<nav class="my-2 my-md-0 mr-md-10">
		<a class="p-2 text-dark" href="generar-mesa">Mesa</a>        
		<a class="p-2 text-dark" href="calculadora"> Calculadora</a> 
		<a class="p-2 text-dark" href="materiales"> Materiales</a>  
		
		<!--<a class="p-2 text-dark" href="loginUser">LoginUsuario</a>   -->   
	</nav>
	<c:if test="${empty usuario}">
		<a class="btn btn-outline-primary" href="login">Login</a>
	</c:if>
	<c:if test="${!empty usuario}">
		<a class="p-2 text-dark" href="backoffice/materiales"> Materiales</a>
		<a class="p-2 text-dark" href="backoffice/usuarios"> Usuarios</a>
		<a class="p-2 text-dark" href="backoffice/rol"> Roles</a>
		
		<span class="badge badge-secondary">${usuario }</span>
		<a class="btn btn-outline-danger float-right " href="logout">Logout</a>
	</c:if>
</div>
<div class="container">