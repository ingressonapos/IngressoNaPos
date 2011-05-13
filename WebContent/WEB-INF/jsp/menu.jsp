<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${usuarioSessao.usuarioAutenticado}">
<div>
<ul class="menu">
<li class="top"><a href="<c:url value='/'/>" target="_self" class="top_link"><span><fmt:message key="menu_home" /></span></a>
</li>
<c:if test='${usuarioSessao.usuario.perfil.descricao ==	"Secretaria"}'>
<li class="top"><a href="<c:url value='/candidato/lista'/>" target="_self" class="top_link"><span><fmt:message key="menu_candidatos" /></span></a>
</li>
</c:if>
<li class="top"><a href="javascript:void(0)" target="_self" class="top_link"><span><fmt:message key="menu_cadastro" /></span></a>
<ul class="sub">
<li><a href="<c:url value='/cadastro/dadosPessoais'/>" target="_self"> <fmt:message key="index_lnk_cadastro_dados_pessoais" /></a></li>
<li><a href="<c:url value='/curriculo/dadosCurriculo'/>" target="_self"> <fmt:message key="index_lnk_cadastro_curriculo" /></a></li>
<li><a href="<c:url value='/cadastro/solicitarRecomendacao'/>" target="_self"> <fmt:message key="index_lnk_cadastro_recomendacao" /></a></li>
<li><a href="<c:url value='/cadastro/dadosVaga'/>" target="_self"> <fmt:message key="index_lnk_cadastro_vaga" /></a></li>
</ul>
</li>
<li class="top"><a href="<c:url value='/logout'/>" target="_self" class="top_link"><span> <fmt:message key="login_logout" /></span></a>
</li>
</ul>
</div>
</c:if>