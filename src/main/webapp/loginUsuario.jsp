<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

<div id="login">

  <form class="form-signin" action=loginUser method="post">     

      <div class="form-label-group">
         <label for="usuario">Nombre Usuario:</label>
        <input type="text" class="form-control"
               name="usuario" 
               placeholder="Nombre Usuario" 
               required autofocus
               value="">
      </div>

      <div class="form-label-group">
      	<label for="id">ID:</label>
        <input type="text" 
               name="id" 
               class="form-control" 
               placeholder="Pon tu id" required
               value="">
       </div>
     
      <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
      
    </form>

</div>



<jsp:include page="templates/footer.jsp"></jsp:include>