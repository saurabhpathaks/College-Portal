
<%

String textmessage=(String)request.getAttribute("msg");
if(textmessage!=null)
{
	

%>
<span style="colore:red;font-size:medium;font-family:Comic Sans MS">
<%=textmessage %>

</span>
<%} %>
