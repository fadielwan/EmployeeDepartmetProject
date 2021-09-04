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
		<c:when test="${projectForm['new']}">
			<h3>Add Project</h3>
		</c:when>
		<c:otherwise>
			<h3>Update Project</h3>
		</c:otherwise>
	</c:choose>	 
		</div>
      
	<form:form class="form-vertical"  id="projectForm" method="post" modelAttribute="projectForm" 
	 action="./addProject" >
 
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
		
			<spring:bind path="description">
			<div class="col-lg-4 ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">description</label>
				<div class="col-sm-10">
					<form:input path="description" type="text" class="form-control " id="description" placeholder="description" />
					<form:errors path="description" class="control-label" />
				</div>
			</div>
		
          </spring:bind>
			
		
			
			<spring:bind path="employees">
				<label class="col-sm-12" for="emp">Employee:</label>   
				    <select  class=" col-sm-4"  id="emp"   name="emp"  multiple="multiple">
  <option > </option>
     <c:forEach var="d" items="${empList}" >
        <option value="${d.id}">${d.name}</option>
     </c:forEach>
</select>
</spring:bind>
</div>
		<div class="col-sm-12" style="margin-top: 40px">
				<c:choose>
					<c:when test="${projectForm['new']}">
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

