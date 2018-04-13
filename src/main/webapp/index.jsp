<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>
<%
	// Scriplet < %  ...   % >
	// varias sentencias 
	String nombre = "pepe";
	String hora = "10:78";

%>

<h2>Hello <%=nombre%></h2>
<p><%=hora%></p>
<!-- <%
//Lanza adrede un NullPointerException y nos mostrar la pagina de error.jsp 
//Hemos configurado este comportamiento en web.xml <error-page>

	//String nulo= null;
	//nulo.length();
%> -->
<a href="generar-mesa"> ¿Quieres Comprar una Mesa ?</a>


<jsp:include page="templates/footer.jsp"></jsp:include>