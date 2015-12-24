<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 

<t:layout title="添加人物">
	<div class="pull-right"><a href="/person/add" class="btn btn-primary">添加</a></div>
    <table class="table table-striped">
    	<thead>
    		<th>姓名</th>
    		<th>生命状态</th>
    		<th>父节点</th>
    		<th>描述</th>
    	</thead>
    	<tbody>
    	<c:forEach items="${personList}" var="person">
    		<tr>
    			<td><c:out value="${person.name}"/></td>
    			<td><c:out value="${person.lifeStatus.label}"/></td>
    			<td><c:out value="${person.parent.name}"/></td>
    			<c:set var="dlength" value="${15}"/>
    			<td><span style="font-size: 70%;"><c:out value="${fn:substring(person.description, 0, dlength)}"/> <c:if test="${fn:length(person.description) > dlength}"><a href="#" class="descripton-detail">详细</a></c:if></span></td>
    		</tr>
    	</c:forEach>
    	</tbody>
    	<tfoot><tr><td colspan="100%"></td></tr></tfoot>
    </table>
    <script type="text/javascript" src="/assets/js/person.js"></script>
</t:layout>