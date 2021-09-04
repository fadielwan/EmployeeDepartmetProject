<%@include file="/WEB-INF/views/includes/header.jsp"%>
<%@include file="/WEB-INF/views/includes/navi.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>




<div class="col-lg-12">
	<div class="panel panel-default">
		<c:if test="${success != null}">
			<div class="alert alert-success alert-dismissable">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
				<center>
					<p>${success}</p>
				</center>
			</div>
		</c:if>
		<c:if test="${fail != null}">
			<div class="alert alert-danger">
				<center>
					<p>${fail}</p>
				</center>
			</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>

		<div class="panel-heading">
			<h3>Projects</h3>
		</div>

		<div class="panel-body">
			<table class="table table-condensed"
				style="border-collapse: collapse;">

				<thead>
					<tr>
						<th>Name</th>
						<th>Description</th>
						<th>Employee</th>
						<th>Action</th>

					</tr>
				</thead>

				<tbody>

					<c:forEach items="${projectList}" var="dept">
						<tr data-toggle="collapse" data-target="#dept_${dept.id}"
							class="accordion-toggle">

							<td contenteditable='false'>${dept.name}</td>
							<td contenteditable='false'>${dept.description}</td>
							<td><button class="btn btn-default btn-xs"><span class="glyphicon glyphicon-info-sign"></span></button></td>
							<td>
						<spring:url value="./updateProject?id=${dept.id}" var="updateUrl" /> 
						<spring:url value="./deleteProject?id=${dept.id}"   var="deleteUrl" /> 
                        <input type="button"  value="Delete "class="btn btn-danger"  id="button1"    onclick="location.href='${deleteUrl}'" ></input>
                        <input type="button"  value="Update "class="btn btn-primary" id="button2"  onclick="location.href='${updateUrl}'" ></input>
						
				        </td>
						<tr>
							<td colspan="12" class="hiddenRow">
								<div class="accordian-body collapse" id="dept_${dept.id}">
									<table class="table table-striped">
										<thead>
											<tr>
												<th>Name</th>
												<th>Department</th>
											</tr>
										</thead>

										<c:if test="${empty dept.employees}">
											<tr>
												<td>There is no employee</td>
											</tr>
										</c:if>

										<c:if test="${!empty dept.employees}">
											<c:forEach items="${dept.employees}" var="emp">
												<tr>
													<td>${emp.name }</td>
													<td>${emp.department.name }</td>
											
												</tr>
											</c:forEach>
										</c:if>

									</table>
								</div>
							</td>

						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>

	</div>




	<%@include file="/WEB-INF/views/includes/footer.jsp"%>