<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:layout>
    <jsp:attribute name="title">Welcome</jsp:attribute>
    <jsp:body>
        <table>
        	<c:forEach items="${personList}" var="person">
        		<tr>
        			<td><c:out value="${person.name}"/></td>
        			<td><c:out value="${person.description}"/></td>
        		</tr>
        	</c:forEach>
        </table>
    </jsp:body>
</t:layout>