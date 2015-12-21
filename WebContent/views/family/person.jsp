<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:layout>
    <jsp:attribute name="title">Edit Person</jsp:attribute>
    <jsp:body>
    	<form:form modelAttribute="personModel" method="post" cssClass="form-horizontal">
    	<div class="form-group">
    		<div class="col-sm-offset-2 col-sm-10">
	      		<form:errors path="*" cssClass="text-danger"/>
	        </div>
    	</div>  
        <input type="hidden" name="id" />
        <div class="form-group">
		    <label for="name" class="col-sm-2 control-label">姓名：</label>
		    <div class="col-sm-10">
		    	<form:input path="name" type="text" class="form-control" id="name" placeholder="姓名" />
		        <form:errors path="name" cssClass="text-danger" />
		    </div>
		</div>
		<div class="form-group">
		    <label for="parentId" class="col-sm-2 control-label">父节点：</label>
		    <div class="col-sm-10">
		    	<form:select path="parentId" class="form-control" id="parentId" items="${personList}" itemValue="id" itemLabel="name"/>
		        <form:errors path="parentId" cssClass="text-danger" />
		    </div>
		</div>
		<div class="form-group">
		    <label for="lifeStatus" class="col-sm-2 control-label">生命状态：</label>
		    <div class="col-sm-10">
		    	<form:radiobuttons path="lifeStatus" id="lifeStatus" items="${statusList}" itemLabel="label" />
		        <form:errors path="lifeStatus" cssClass="text-danger" />
		    </div>
		</div>
        <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		    	<button type="submit" class="btn btn-default">保存</button>
		    </div>
		</div>
    </form:form>
    </jsp:body>
</t:layout>