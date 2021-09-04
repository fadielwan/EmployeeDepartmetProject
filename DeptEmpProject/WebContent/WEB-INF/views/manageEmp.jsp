<%@include file="/WEB-INF/views/includes/header.jsp"%>
<%@include file="/WEB-INF/views/includes/navi.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
		
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
		<c:when test="${empForm['new']}">
			<h3>Add Employee</h3>
		</c:when>
		<c:otherwise>
			<h3>Update Employee</h3>
		</c:otherwise>
	</c:choose>	 
		</div>
      
	<form:form class="form-vertical"  id="empForm" method="post" modelAttribute="empForm" 
	 action="./addEmp" >

		<form:hidden path="id" />
		<spring:bind path="name">
			<div class="col-lg-4 ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Name</label>
				<div class="col-sm-12">
					<form:input path="name" type="text" class="form-control " id="name"
						placeholder="Name" required="required"/>
					<form:errors path="name" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="materialstatus">
			<div class="col-lg-4 ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">MaterialStatus</label>
				<div class="col-sm-12">
					<form:input path="materialstatus" type="string"
						class="form-control " id="materialstatus"
						placeholder="materialstatus" required="required" />
					<font color="red"> <span class="col-lg-4"
						id="contact_error_message"></span></font>
					<form:errors path="materialstatus" class="control-label" />
				</div>
			</div>
		</spring:bind>



		<spring:bind path="salary">
			<div class="col-lg-4 ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Salary</label>
				<div class="col-sm-12">

					<form:input path="salary" type="number" class="form-control"
						id="salary" placeholder="salary" required="required" />
					<form:errors path="salary" class="control-label" />
				</div>
			</div>
		</spring:bind>


		<label class="col-sm-12" for="department">Department:</label>
		<div class="col-sm-12">
			<select class=" col-sm-4" id="department" name="dept" required="required">
				<option value="-1">Please Select</option>
				<c:forEach var="d" items="${deptList}">
					<option value="${d.id}">${d.name}</option>
				</c:forEach>
			</select>
		</div>


		<spring:bind path="dateofbirth">
			<div class="col-lg-4 ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">dateofbirth</label>
				<div class="col-sm-12">
					<form:input type="text" path="dateofbirth" class="form-control "
						id="datepicker" placeholder="dd/mm/yy" required="required"/>

					<form:errors path="dateofbirth" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<div class="col-sm-12" style="margin-top: 40px">
				<c:choose>
					<c:when test="${empForm['new']}">
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

	</div>

</div>

<%@include file="/WEB-INF/views/includes/footer.jsp"%>

