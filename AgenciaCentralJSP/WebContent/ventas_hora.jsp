<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.Date"%>
<%@ page import ="java.text.*"%>

<%@ page import ="application.beans.TicketBean"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VENTAS POR FRANJA HORARIA</title>
</head>
<body>
<form action="/AgenciaCentralJSP/ReporteVentasFranja" method="post">
<div class="form-title"><h2>VENTAS POR FRANJA HORARIA</h2></div>
 
HORA INICIO (hh:mm:ss): <input class="form-field" type="date" name="h_inicio" /><br /> 
HORA FIN (hh:mm:ss): <input class="form-field" type="date" name="h_fin" /><br /> 
<input class="submit-button" type="submit" value="ENVIAR" name="opt"/>
<input class="submit-button" type="submit" value="VOLVER" name="opt"/><br />
 
</form>
<%
String HI = (String)session.getAttribute("HI");
String HF = (String)session.getAttribute("HF");
if ((HI!=null)&&(HF!=null)){
	%>
	<br/> 
	FUERON ENCONTRADAS LAS SIGUIENTES ENTRE LA HORA <%=HI%> Y LA HORA <%=HF%>
	<br/> 
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
    String Horas;
    String Minutos;
    String Segundos;
    lista_tickets = (ArrayList <TicketBean>) session.getAttribute("lista_tickets");
    String[] componentes_fecha;
    String[] componentes_hora;
  	int horas;
  	int minutos;
  	int segundos;
  	int horas_I;
  	int minutos_I;
  	int segundos_I;
  	int horas_F;
  	int minutos_F;
  	int segundos_F;
  	
  	String[] componentesI;
  	String[] componentesF;
  	componentesI = HI.split(":");
  	componentesF = HF.split(":");
  	
  	horas_I = Integer.parseInt(componentesI[0]);
  	minutos_I = Integer.parseInt(componentesI[1]);
  	//segundos_I = Integer.parseInt(componentesI[2].split(".")[0]);
  	
  	horas_F = Integer.parseInt(componentesF[0]);
  	minutos_F = Integer.parseInt(componentesF[1]);
  	//segundos_F = Integer.parseInt(componentesF[2].split(".")[0]);
  	boolean imprimir;
  
	for (int i = 0; i < lista_tickets.size(); i++) {
		imprimir = true;
		T= lista_tickets.get(i);
		componentes_fecha = T.getFechaHoraVenta().toString().split(" ");
		componentes_hora = componentes_fecha[1].split(":");
		
		horas =  Integer.parseInt(componentes_hora[0]);
		minutos =  Integer.parseInt(componentes_hora[1]);
		//segundos =  Integer.parseInt(componentes_hora[2]);
		if ((horas<horas_I)||(horas>horas_F)){
			imprimir = false;
			// Fuera de rango por horas
		}else{
			if ((horas==horas_I)){
				if ((minutos<minutos_I)){
					imprimir = false;
					// Fuera de rango por mintuos Inicio
				}/*else{
					if ((minutos==minutos_I)){
						
						if (segundos<segundos_I){
							imprimir = false;
							// Fuera de rango por segundos Inicio
						}
						
					}
				}*/
			}
			if ((horas==horas_F)){
				if ((minutos>minutos_F)){
					imprimir = false;
					// Fuera de rango por mintuos Final
				}/*else{
					if ((minutos==minutos_F)){
						if (segundos>segundos_F){
							imprimir = false;
							// Fuera de rango por segundos Final
						}
					}
				}*/
			}
		}
		if (imprimir){
		
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
		
	}
	%></table><%
}%>

</body>
</html>