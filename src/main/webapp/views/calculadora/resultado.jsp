<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.nidea.pojo.Material"%>
<%@page import="com.ipartek.formacion.nidea.pojo.Mesa"%>

<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>





<%
	float resul = (Float)request.getAttribute("resultado");	
%>		

<h1>Resultado de  la Operación <span class="badge badge-primary"><%=resul%></span> </h1>




<jsp:include page="/templates/footer.jsp"></jsp:include>