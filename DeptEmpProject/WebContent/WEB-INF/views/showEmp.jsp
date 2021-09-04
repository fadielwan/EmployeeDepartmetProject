<%@include file="/WEB-INF/views/includes/header.jsp"%>
<%@include file="/WEB-INF/views/includes/navi.jsp"%>
<style>
.button {
	background-color: 858787;
	border: none;
	color: 513F05;
}
</style>
<div class="container">
	<font color="#808080"><h1>Employee Detail</h1></font> <br />
	<div class="panel-body">

		<table id="m" class="table table-condensed"
			style="border-collapse: collapse;">
			<thead>
				<tr>
					<th>Name</th>
					<th>Salary</th>
					<th>MaterialStatus</th>
					<th>DateOfBirth</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${sortedEmp}" var="emp">
					<tr>
						<td>${emp.name }</td>
						<td>${emp.salary }</td>
						<td>${emp.materialstatus }</td>
						<td>${emp.dateofbirth}</td>

					</tr>
				</c:forEach>
				<button onclick="goBack()" class="button">Go Back</button>
				<script>
					function goBack() {
						window.history.back();
					}
				</script>
				</div>