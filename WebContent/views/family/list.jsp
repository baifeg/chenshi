<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:layout>
    <jsp:attribute name="title">Welcome</jsp:attribute>
    <jsp:body>
        <table class="table table-striped">
        	<thead>
        		<th>姓名</th>
        		<th>生命状态</th>
        		<th>父节点</th>
        	</thead>
        	<tbody>
        	<c:forEach items="${personList}" var="person">
        		<tr>
        			<td><c:out value="${person.name}"/></td>
        			<td><c:out value="${person.lifeStatus.label}"/></td>
        			<td><c:out value="${person.parent.name}"/></td>
        		</tr>
        	</c:forEach>
        	</tbody>
        	<tfoot><tr><td colspan="100%"></td></tr></tfoot>
        </table>
    </jsp:body>
</t:layout>