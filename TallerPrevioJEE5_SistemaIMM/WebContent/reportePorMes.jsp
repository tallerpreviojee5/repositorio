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
		<h:panelGrid columns="1">
			<h2>Reporte por Mes</h2>
		</h:panelGrid>

		
		<h:messages showDetail="false" showSummary="true"/>
		<h:panelGrid columns="3">
			<h:outputText value="Ingrese año y mes aaaa/mm" />
 			<h:inputText  value="#{reportePorMesManagedBean.anio_mes}" required="true"
 			requiredMessage="Debe ingresar año y mes"/> 
 			<h:commandButton action="#{reportePorMesManagedBean.accion}" value="Enviar" />
 		</h:panelGrid>
 				<h:panelGrid columns="8">
	
		<h:dataTable value="#{reportePorMesManagedBean.tabla.registrosTickets}" var="tickets" border = "1">
		<h:column>
			<f:facet name="header"> 
				<h:outputText value = "Nro Ticket"/>
			</f:facet>
			<h:outputText value="#{tickets.nroTicket}" />
		</h:column>
		
		<h:column>
			<f:facet name="header"> 
				<h:outputText value = "Id Agencia"/>
			</f:facet>
			<h:outputText value="#{tickets.idAgencia}" />
		</h:column>
		<h:column>
			<f:facet name="header"> 
				<h:outputText value = "Matricula"/>
			</f:facet>		
			<h:outputText value="#{tickets.matriculaAuto}" />
		</h:column>
		<h:column>
			<f:facet name="header"> 
				<h:outputText value = "Fecha Venta"/>
			</f:facet>		
			<h:outputText value="#{tickets.fechaVenta}" />
		</h:column>
		
		
		<h:column>
			<f:facet name="header"> 
				<h:outputText value = "Inicio Servicio"/>
			</f:facet>
			<h:outputText value="#{tickets.fechaInicioServicio}" />
		</h:column>
		
		<h:column>
			<f:facet name="header"> 
				<h:outputText value = "Minutos"/>
			</f:facet>
			<h:outputText value="#{tickets.minutos}" />
		</h:column>

		<h:column>
			<f:facet name="header"> 
				<h:outputText value = "Importe"/>
			</f:facet>
			<h:outputText value="#{tickets.importe}" />
		</h:column>

		<h:column>
			<f:facet name="header"> 
				<h:outputText value = "Estado"/>
			</f:facet>
			<h:outputText value="#{tickets.estado}" />
		</h:column>
										
		</h:dataTable>
		</h:panelGrid>

	<h:commandButton value="Volver" action="menu.jsp" type="submit" /> 
 		
 		

 		
</h:form>		
</f:view>
</body>
</html>