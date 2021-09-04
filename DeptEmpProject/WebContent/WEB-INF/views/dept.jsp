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
			<h3>Departments</h3>
		</div>

		<div class="panel-body">
			<table class="table table-condensed"
				style="border-collapse: collapse;">

				<thead>
					<tr>
						<th>Dept. Name</th>
						<th>Location</th>
						<th>Manager</th>
						<th>Employee</th>
						<th>Action</th>

					</tr>
				</thead>

				<tbody>

					<c:forEach items="${deptList}" var="dept">
						<tr data-toggle="collapse" data-target="#dept_${dept.id}"
							class="accordion-toggle">

							<td contenteditable='false'>${dept.name}</td>
							<td contenteditable='false'>${dept.location}</td>
							<td contenteditable='false'>${dept.manager}</td>
							<td><button class="btn btn-default btn-xs"><span class="glyphicon glyphicon-info-sign"></span></button></td>
							<td>
						<spring:url value="./updateDept?id=${dept.id}" var="updateUrl" /> 
						<spring:url value="./deleteDept?id=${dept.id}"   var="deleteUrl" /> 
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
												<th>DOB</th>
												<th>MaterialStatus</th>
												<th>salary</th>


											</tr>
										</thead>

										<c:if test="${empty dept.employeeList}">
											<tr>
												<td>There is no employee</td>
											</tr>
										</c:if>

										<c:if test="${!empty dept.employeeList}">
											<c:forEach items="${dept.employeeList}" var="emp">
												<tr>
													<td>${emp.name }</td>
													<td>${emp.dateofbirth }</td>
													<td>${emp.materialstatus}</td>
													<td>${emp.salary}</td>
											
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