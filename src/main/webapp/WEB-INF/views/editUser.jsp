<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration Form</title>
    <%@ include file = "header.jsp" %>
</head>
<body>
<div>
    <form action="update" method="post">
</div>

<div>
    <label>id</label>
    <input type="number" name="id" readonly value = "${user.id}">
</div>
<div>
    <label>User Name</label>
    <input type="text" name="username" value = "${user.username}">
</div>

<div>
    <label>Password</label>
    <input type="password" name="password" value = "${user.password}">
</div>
<div>
    <label>dob</label>
    <input type="date" name="dob" value = "${user.dob}">
</div>
<div>
    <label>Email</label>
    <input type="email" name="email" value = "${user.email}">
</div>
<div>
    <label>Mobile No</label>
    <input type="number" name="mobileNo" value = "${user.mobileNo}">
</div>
<div>
    <label>Address</label>
    <input type="text" name="address" value = "${user.address}">
</div>
<div>
    <label>Gender</label>
    <input type="radio" name="gender" value ="Male" ${user.gender=='Male'?'checked':'' } >Male
    <input type="radio" name="gender" value ="Female" ${user.gender=='Female'?'checked':'' }>Female

</div>
<div>
    <label>Hobbies</label>
    <input type="checkbox" name="hobbies" value = "swimming" <c:if test = "${fn:contains(user.hobbies, 'swimming')}">checked</c:if>>swimming
    <input type="checkbox" name="hobbies" value = "chess" <c:if test = "${fn:contains(user.hobbies, 'chess')}">checked</c:if>>chess
</div>
<div>
    <label>Nationality</label>
    <select name =  "nationality">

        <option value  =  "Nepalese" ${user.nationality=='Nepalese'?'selected':'' }> Nepalese </option>
        <option value  =  "Indian" ${user.nationality=='Indian'?'selected':'' }> Indian </option>
        <option value  =  "American" ${user.nationality=='American'?'selected':'' }> American </option>

    </select>
</div>
<div>

    <label>Comments</label>
    <textarea rows="6" cols="30"  name =  "comments" ${user.comments}></textarea>
</div>

<div>
    <input type ="submit" value =  "Submit">
</div>
</body>
</html>