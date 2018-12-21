<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Shampoo's</title>
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Shampoo Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			
			<input type="button" value="Add Shampoo"
				onclick="window.location.href='showFormForAdd'; return false;"
			/>
			<table>
				<tr>
					<th>Name</th>
					<th>Company</th>
				</tr>
			<c:forEach var="tempShampoo" items="${shampoos}">
				<tr>
					<td>${tempShampoo.name}</td>
					<td>${tempShampoo.company}</td>
				</tr>
			</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>