<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 <%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
 <sql:setDataSource var="ds" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/demo" user="root" password="root"/>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:out value="${message}" />
<h2 align="left" style="font: oblique;">BOARDING POINT</h2><br>
<sql:query var="rs" dataSource="${ds}">
select * from cities
</sql:query>
<select>
<c:forEach var="cities" items="${rs.rows}">
<%--<c:out value="${cities.boarding_point}"/>
<c:out value="${cities.drop_point}"/> --%>

<option value="<c:out value="${cities.boarding_point}"/>"><c:out value="${cities.boarding_point}"/></option>
</c:forEach>
</select>

</body>
</html>