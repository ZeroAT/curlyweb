<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<title>Add New Shampoo</title>
</head>
<body>
			<table>
				<tr>
					<th>Company</th>
				</tr>
			<c:forEach var="tempCompanies" items="${companies}">
				<tr>
					<td>${tempCompanies.name}</td>
				</tr>
			</c:forEach>
			</table>

	<div id="wrapper">
	
		<div id="header">
			<h2>Add New Shampoo</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Shampoo</h3>
		<form:form action="saveShampoo" modelAttribute="shampoo" method="POST">
		
			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input path="name" /></td>
					</tr>
					<tr>
						<td><label>Company:</label></td>
						<td><form:input path="company" /></td>
					</tr>
					
					<tr>
						<td><label>Ingredients:</label></td>
						<td><form:select multiple="true" path="name">
							<form:options items="${ingredients}" itemLabel="name" itemValue="id" />
							</form:select></td>
					</tr>
				</tbody>
			
			</table>
		
		
		</form:form>
	</div>

</body>

</html>