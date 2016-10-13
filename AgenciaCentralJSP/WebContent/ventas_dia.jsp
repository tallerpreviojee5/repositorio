<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="application.beans.TicketBean"%>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VENTAS DEL DIA</title>
</head>
<body>

<form action="/AgenciaCentralJSP/ReporteVentasDia" method="post">
<div class="form-title"><h2>VENTAS DEL DIA</h2></div>
 
FECHA(dd-MM-aaaa): <input class="form-field" type="date" name="dia" /><br /> 
 
<input class="submit-button" type="submit" value="ENVIAR" name="opt"/>
<input class="submit-button" type="submit" value="VOLVER" name="opt"/><br />
 
</form> 
<%
String F = (String)session.getAttribute("F");
if (F!=null){
	%>
	<table border=1 cellpadding=5>
    <tr>
      <th>NÚMERO TICKET</th>
      <th>MATRÍCULA</th>
      <th>FECHA VENTA</th>
      <th>IMPORTE</th>
      <th>ID TERMINAL</th>
      <th>ESTADO</th>
    </tr>
    <%
    ArrayList <TicketBean> lista_tickets = new ArrayList<TicketBean>();
    TicketBean T = new TicketBean();
    lista_tickets = (ArrayList <TicketBean>) session.getAttribute("lista_tickets");
	for (int i = 0; i < lista_tickets.size(); i++) {
		T= lista_tickets.get(i);
		%>
		<tr>
        	<th><%=T.getNroTicket()%></th>
        	<th><%=T.getMatricula()%></th>
        	<th><%=T.getFechaHoraVenta().toString()%></th>
        	<th><%=T.getImporte()%></th>
        	<th><%=T.getIdTerminal()%></th>
        	<th><%=T.getEstado()%></th>
      	</tr>
		<%
	}
	%></table><%
}%>

</body>
</html>