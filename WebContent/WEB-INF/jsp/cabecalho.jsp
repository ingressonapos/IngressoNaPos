<%
	response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
	response.setDateHeader("Expires", -1); //evita o caching no servidor proxy
%>
<div class="fundo_topo"></div>
<div align="center">
	<a href="http://www.ime.usp.br/pos">
		<img src="<c:url value='/images/pos_topo.gif'/>" width="700" border="0" height="80">
	</a>
</div>
  <table width="100%" align="center" border="0" cellspacing="0">
    <tbody><tr>
        <td bgcolor="#b31b1b" height="1px"></td>
      </tr>
      <tr>
        <td bgcolor="#ebebeb" height="1px"></td>
      </tr>
    </tbody>
  </table>