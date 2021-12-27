<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add A Ninja</title>
  <!-- Bootstrap -->
  <link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
</head>
<body>
    <div class="container"> <!-- Beginning of Container -->
        <h1>Add a Ninja</h1>
        <form:form action="/ninja/save" method="post" modelAttribute="ninja">
        <p>
        	<form:label path="firstName">First Name: </form:label>
        	<form:errors path="firstName"/>
        	<form:input path="firstName"/>
        </p>
        <p> 	
        	<form:label path="lastName">Last Name: </form:label>
        	<form:errors path="lastName"/>
        	<form:input path="lastName"/>
        </p>
         <p> 	
        	<form:label path="age">Age: </form:label>
        	<form:errors path="age"/>
        	<form:input type="number" path="age"/>
        </p>
       	<form:select path="dojo">
			<c:forEach items="${dojos}" var="dojo">
        		<option value="${dojo.id}">${dojo.name}</option>
    		</c:forEach>
		</form:select>
		<input type="submit" value="Create"/>
        </form:form>
    </div> <!-- End of Container -->
</body>
</html>