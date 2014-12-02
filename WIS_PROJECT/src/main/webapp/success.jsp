<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>login successful</title>
</head>
<body>

<h2>Submitted Login Information</h2>
   <table>
    <tr>
        <td>username</td>
        <td>${username}</td>
    </tr>
    <tr>
        <td>password</td>
        <td>${password}</td>
    </tr>
</table>  
</body>
</html>