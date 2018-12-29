<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<title>Add New Shampoo</title>
<script type="text/javascript" src="/<web-context-root>/js/jquery-1.4.3.min.js"></script> 
<script type="text/javascript" src="/<web-context-root>/js/jquery.magicsearch.js"></script> 

<script><td>${ingredient.name}</td>
$(".test").chosen({
    disable_search_threshold: 10,
    no_results_text: "Oops, nothing found!",
    width: "95%"
  });

</script>
</head>
<body>
$('.test').chosen().change(function(){
	    var myValues = $('.test').chosen().val();
		console.log(myValues);
	    // then do stuff with the array

	});
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
						<td><form:select multiple="true" path="theIngredients" cssClass="test">
							<form:options items="${ingredients}" itemLabel="name" itemValue="id" />
							</form:select></td>
					</tr>
				</tbody>
			
			</table>
		
		
		</form:form>
	</div>

</body>

</html>


<form action ="" method="post">
	
	<form:bind path="shampoo.name">
		<input type="text" name="${status.expression}" value="${status.value}"><br>
	</form:bind>
	<form:bind path="ingredients.name">
		<input class="magicsearch" id="magicsearch" type="text" name="${status.expression}" value="${status.value}">
	</form:bind>
	
	<input type="submit" value="Create"/>
	
	
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
	<title>Add New Shampoo</title>
	<script src="${pageContext.request.contextPath}/resources/jquery-3.3.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/chosen.jquery.js"></script>
	

    <link type="text/css" href="<%=request.getContextPath() %>/resources/chosen.css" rel="stylesheet"/> 


</head>
<body>
	

          <select data-placeholder="Choose a Country..." class="chosen-select" multiple tabindex="4">
                      <option value="Viet Nam">Viet Nam</option>
            <option value="Virgin Islands, British">Virgin Islands, British</option>
            <option value="Virgin Islands, U.S.">Virgin Islands, U.S.</option>
            <option value="Wallis and Futuna">Wallis and Futuna</option>
            <option value="Western Sahara">Western Sahara</option>
            <option value="Yemen">Yemen</option>
          </select>
          
          <form:select multiple="true" path="theIngredients">
							<form:options items="${ingredients}" itemLabel="name" itemValue="id" />
			</form:select>

</body>

</html>