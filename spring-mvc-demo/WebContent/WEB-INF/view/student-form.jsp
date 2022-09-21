<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
	<title>Student Registration Form</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="student">
		First name: <form:input path="firstName" />
		
		<br>
		
		Country:
		
		<form:select path="country">
		
			<form:options items="${student.countryOptions}"/>
			
		</form:select>
		
		<br>
		
		Favorite language:
		
		Java <form:radiobutton path="favoriteLanguage" value="Java"/>
		C# <form:radiobutton path="favoriteLanguage" value="C#"/>
		Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
		PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
		
		<br>
		
		Operating Systems:
		
		Linux <form:checkbox path="operatingSystems" value="Linux"/>
		Mac <form:checkbox path="operatingSystems" value="Mac"/>
		Windows <form:checkbox path="operatingSystems" value="Windows"/>
		
		<br>
		
		Last name: <form:input path="lastName" />
		
		<input type="submit" value="Submit" />
		
		
	</form:form>

</body>

</html>