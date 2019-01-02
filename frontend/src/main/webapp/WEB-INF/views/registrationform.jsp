<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<pre>
<c:url value="/all/register" var="url"></c:url>
<form:form action="${url }" method="post" modelAttribute="customer">
CUSTOMER DETAILS
<form:label path="firstname">Enter Firstname</form:label>
<form:input path="firstname"/>
<form:label path="lastname">Enter Lastname</form:label>
<form:input path="lastname"/>
<form:label path="phonenumber">Enter Phonenumber</form:label>
<form:input path="phonenumber"/>
<hr>
LOGIN CREDENTIALS
<form:label path="user.email">Enter Email</form:label>
<form:input path="user.email" type="email"/>
<form:label path="user.password">Enter Password</form:label>
<form:input path="user.password" type="password"/>
<form:hidden path="user.enabled" value="true"/>
<form:hidden path="user.authorities.role" value="ROLE_USER"></form:hidden>
<hr>
BILLING ADDRESS
<form:label path="billingAddress.apartmentnumber">Enter Apartmentnumber</form:label>
<form:input path="billingAddress.apartmentnumber"/>
<form:label path="billingAddress.streetname">Enter Streetname</form:label>
<form:input path="billingAddress.streetname"/>
<form:label path="billingAddress.city">Enter City</form:label>
<form:input path="billingAddress.city"/>
<form:label path="billingAddress.state">Enter State</form:label>
<form:input path="billingAddress.state"/>
<form:label path="billingAddress.country">Enter Country</form:label>
<form:input path="billingAddress.country"/>
<form:label path="billingAddress.zipcode">Enter Zipcode</form:label>
<form:input path="billingAddress.zipcode"/>
<hr>
SHIPPING ADDRESS
<form:label path="shippingAddress.apartmentnumber">Enter Apartmentnumber</form:label>
<form:input path="shippingAddress.apartmentnumber"/>
<form:label path="shippingAddress.streetname">Enter Streetname</form:label>
<form:input path="shippingAddress.streetname"/>
<form:label path="shippingAddress.city">Enter City</form:label>
<form:input path="shippingAddress.city"/>
<form:label path="shippingAddress.state">Enter State</form:label>
<form:input path="shippingAddress.state"/>
<form:label path="shippingAddress.country">Enter Country</form:label>
<form:input path="shippingAddress.country"/>
<form:label path="shippingAddress.zipcode">Enter Zipcode</form:label>
<form:input path="shippingAddress.zipcode"/>
<input type="submit" value="REGISTER">
</form:form>
</pre>
</div>
</body>
</html>
