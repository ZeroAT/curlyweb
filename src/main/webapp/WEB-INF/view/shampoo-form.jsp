<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
	<title>Add New Shampoo</title>
	<script src="${pageContext.request.contextPath}/resources/jquery-3.3.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/chosen.jquery.js"></script>
	

    <link type="text/css" href="<%=request.getContextPath() %>/resources/chosen.css" rel="stylesheet"/> 
<script>

$(document).ready(function(e){
	
	$(".test").chosen({

	  });
	
	
});


</script>

</head>
<body>
	
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
						<td><form:select cssClass="test" multiple="true" path="${ingredient.name}" >
							<form:options items="${ingredients}" itemLabel="name" itemValue="id" />
							</form:select></td>
					</tr>
				</tbody>
			
			</table>
		</form:form>

</body>

</html>