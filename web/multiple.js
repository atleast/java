document.write("<table border=\"1\" name=\"multiple\">");
for(i=1;i<=9;i++){
	document.write("<tr>");
	for(j=1;j<=9;j++){

		if(j<=i){
		
			document.write("<td>"+i+"*"+j+"="+i*j)+"</td>";

		}else{

			document.write("<td>&nbsp;</td>");
		}
	}
	document.write("</tr>");

}
document.write("</table>");
