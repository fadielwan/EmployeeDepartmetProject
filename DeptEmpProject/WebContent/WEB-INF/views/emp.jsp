<%@include file="/WEB-INF/views/includes/header.jsp"%>
<%@include file="/WEB-INF/views/includes/navi.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
</head>
<style>
#myInput {
	background-image: url('/css/searchicon.png');
	/* Add a search icon to input */
	background-position: 10px 12px; /* Position the search icon */
	/* /* background-repeat: no-repeat; /* Do not repeat the icon image */
	/*  width: 100%; */ /* Full-width */
	font-size: 16px; /* Increase font-size */
	padding: 12px 20px 12px 40px; /* Add some padding */
	border: 1px solid #ddd; /* Add a grey border 
    margin-bottom: 12px; /* Add some space below the input */
	background-color: #F9FDFD;
}
</style>


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
			<h3>Employee</h3>

		</div>
		<form action=""></form>

		<div class="panel-body">



			<table id="myTable" class="table table-condensed"
				style="border-collapse: collapse;">

				<thead>
					<tr>
						<th>Name</th>
						<th>Salary</th>
						<th>materialstatus</th>
						<th>dateofbirth</th>
						<th>Department</th>


					</tr>
				</thead>
				<tbody>
					<c:if test="${empty employeeList}">
						<tr>
							<td>There is no employee</td>
						</tr>
					</c:if>
					<c:if test="${!empty employeeList}">
						<c:forEach items="${employeeList}" var="emp">
							<tr>
								<td>${emp.name }</td>

								<td>${emp.salary }</td>
								<td>${emp.materialstatus }</td>
								<td>${emp.dateofbirth}</td>
								<td>${emp.department.name}</td>
								<td><spring:url value="./updateEmp?id=${emp.id}"
										var="updateUrl" /> <spring:url
										value="./deleteEmp?id=${emp.id}" var="deleteUrl" /> <input
									type="button" value="Delete " class="btn btn-danger"
									id="button1" onclick="location.href='${deleteUrl}'"></input> <input
									type="button" value="Update " class="btn btn-primary"
									id="button2" onclick="location.href='${updateUrl}'"></input></td>

							</tr>


						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/includes/footer.jsp"%>
