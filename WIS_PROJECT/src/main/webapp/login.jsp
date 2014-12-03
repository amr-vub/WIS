<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>LOGIN</title>
</head>
<body>

<h2>login here:</h2>
<!-- The action value here has to be *.do -->
<form:form method="POST" action="login.do" modelAttribute="myuser">
   <table>
    <tr>
    	<!-- The path value here has to map to the same field in the communicated object
    		Here the communicated object is UserAuthentication  -->
        <td><form:label path="username">username</form:label></td>
        <td><form:input path="username" /></td>
    </tr>
    <tr>
        <td><form:label path="password">password</form:label></td>
        <td><form:input path="password" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>