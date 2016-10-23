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
			<h2>Reporte por Rango de Fechas</h2>
		</h:panelGrid>

		
		<h:messages showDetail="false" showSummary="true"/>
		<h:panelGrid columns="2">
			<h:outputText value="Ingrese fecha de inicio aaaa/mm/dd" />
 			<h:inputText  value="#{reportePorRangoManagedBean.fecha_inicio}" required="true"
 			requiredMessage="Debe ingresar fecha de inicio"/> 
 			<h:outputText value="Ingrese fecha de fin aaaa/mm/dd" />
 			<h:inputText  value="#{reportePorRangoManagedBean.fecha_fin}" required="true"
 			requiredMessage="Debe ingresar fecha de fin"/> 
 			<h:commandButton action="#{reportePorRangoManagedBean.accion}" value="Enviar" />
 		</h:panelGrid>
 				<h:panelGrid columns="8">
	
		<h:dataTable value="#{reportePorRangoManagedBean.tabla.registrosTickets}" var="tickets" border = "1">
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