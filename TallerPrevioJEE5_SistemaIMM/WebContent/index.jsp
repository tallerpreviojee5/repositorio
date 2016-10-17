<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:view>
	<h:form>
		
		<h:messages showDetail="false" showSummary="true"/>
		<h:panelGrid columns="2">

		<h:outputText value="Nombre" />
 		<h:inputText  value="#{usuarioManagedBean.usuario.nombre }" required="true"
 		requiredMessage="El nombre es obligatorio"/> 
		
		
		<h:outputText value="Password" />
		<h:inputText value="#{usuarioManagedBean.usuario.secreto }" required="true"
		requiredMessage="La contraseña es obligatoria"/>
		</h:panelGrid>
		
		
		
		<h:commandButton value="Confirmar" action="#{usuarioManagedBean.accion}" type="submit" />
	</h:form>
</f:view>
</body>
</html>