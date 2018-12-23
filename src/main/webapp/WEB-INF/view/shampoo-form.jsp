<%@ taglib prefix="form" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<title>Add New Shampoo</title>
<script type="text/javascript" src="/<web-context-root>/js/jquery-1.4.3.min.js"></script> 
<script type="text/javascript" src="/<web-context-root>/js/jquery.magicsearch.js"></script> 

</head>
<body>

<form action ="" method="post">
	
	<form:bind path="shampoo.name">
		<input type="text" name="${status.expression}" value="${status.value}">
	</form:bind>
	<form:bind path="ingredient.name">
		<input type="text" name="${status.expression}" value="${status.value}">
	</form:bind>

</form>

</body>

</html>