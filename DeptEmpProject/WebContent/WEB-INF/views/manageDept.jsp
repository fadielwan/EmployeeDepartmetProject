<%@include file="/WEB-INF/views/includes/header.jsp"%>
<%@include file="/WEB-INF/views/includes/navi.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


		
		<div class="panel-body">
		  <c:if test="${success != null}">
                 <div class="alert alert-success">
                     <p>${success}</p>
                 </div>
           </c:if>
		  <c:if test="${fail != null}">
                 <div class="alert alert-danger">
                     <p>${fail}</p>
                 </div>
           </c:if>
           
         <div class="panel-heading">
		  <c:choose>
		<c:when test="${deptForm['new']}">
			<h3>Add Department</h3>
		</c:when>
		<c:otherwise>
			<h3>Update Department</h3>
		</c:otherwise>
	</c:choose>	 
		</div>
          
           
	<form:form class="form-horizontal" method="post" modelAttribute="deptForm" action="./addDept"  >
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />  

		<form:hidden path="id" />
 
		    <spring:bind path="name">
			<div class="col-lg-4 ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Name</label>
				<div class="col-sm-10">
					<form:input path="name" type="text" class="form-control " id="name" placeholder="Name" required="required"/>
					<form:errors path="name" class="control-label" />
				</div>
			</div>
		
            </spring:bind>



		<spring:bind path="location">
			<div class="col-lg-4  ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Address:</label>
				<div class="col-sm-10">
					<form:input path="location" type="text" class="form-control "
						id="location" placeholder="Location" />
					<form:errors path="location" class="control-label" />
				</div>
			</div>

		</spring:bind>

		<spring:bind path="manager">
			<div class="col-lg-4  ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">manager:</label>
				<div class="col-sm-10">
					<form:input path="manager" type="text" class="form-control "
						id="manager" placeholder="Manager" />
					<form:errors path="manager" class="control-label" />
				</div>
			</div>

		</spring:bind>


		<div class="col-sm-12" style="margin-top: 40px">
				<c:choose>
					<c:when test="${deptForm['new']}">
						<button  type="submit" class="btn btn-primary" >Add</button>
						<button type="reset" class="btn"  >Reset</button>
					</c:when>
					<c:otherwise>
						<button type="submit" class="btn btn-primary">Update</button>
						<button   onclick="goBack()"class="btn btn-primary">Go Back</button>
					</c:otherwise>
				</c:choose>
			</div>
			</form:form>
		</div>
<%@include file="/WEB-INF/views/includes/footer.jsp"%>
