<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    


 <html lang="en">
  <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Dashboard</title>
        <link href="/style.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  </head>
    
  <body>

<!-- start table one -->
    <div class="container mt-5 mb-5">
     <h3>Table of active employees and active stores</h3>
         
    <table class="table table-striped ">
      <thead>
       <tr>
         <th scope="col"> active stores</th>
         <th scope="col"> active employees</th>
       </tr>
      </thead>
     
      <tbody>
       <tr>
        <td><c:out value="${activeStores.size()}" /></td>
        <td><c:out value="${activeEmployees.size()}" /></td>
      </tr>
      </tbody>
    </table>
    </div>    
    
<!-- end table one -->

<!-- start table two -->
    <div class="container  mt-5">
     <a  class="mb-2" href='/store/create'> <button class="btn btn-secondary" >Create Store</button> </a> 
         
    <table class="table table-striped">
     <thead>
       <tr>
         <th scope="col">Name</th>
         <th scope="col">Address</th>
         <th scope="col">Store Type</th>
         <th scope="col">Status</th>
         <th scope="col">Number of employees</th>
         <th >Action</th>
       </tr>
     </thead>
     <tbody>
    <c:forEach items="${stores}" var="store">
  
     <tr>
      <td><c:out value="${store.getName()}" /></td>
      <td><c:out value="${store.getAddress()}" /></td>
      <td><c:out value="${store.getStore_type()}" /></td>
      <td><c:out value="${store.getStatus()}" /></td>
      <td><c:out value="${store.employees.size()}" /></td>
      <td>
        <a class="btn btn-success" href='/store/edit/<c:out value="${store.getId()}"/>'> update </a> 
      </td>
      </tr>
  
  </c:forEach>
    </tbody>
   </table>

    </div>        
<!-- end table two -->


<!-- start table three -->
   <div class="container  mt-5">
    <a  class="mb-2" href='/employee/create'> <button class="btn btn-secondary" >Create Employee</button> </a> 
         
    <table class="table table-striped">
     <thead>
       <tr>
         <th scope="col">Name</th>
         <th scope="col">Age</th>
         <th scope="col">Skill</th>
         <th scope="col">Status</th>
         <th >Delete</th>
         <th >Update</th>
       </tr>
     </thead>
     <tbody>
  
    <c:forEach items="${employees}" var="employee">
  
     <tr>
      <td><c:out value="${employee.getName()}" /></td>
      <td><c:out value="${employee.getAge()}" /></td>
            <td><c:out value="${employee.getSkill()}" /></td>
      <td><c:out value="${employee.getStatus()}" /></td>
      <td>
        <a class="btn btn-success " href='/employee/edit/<c:out value="${employee.getId()}"/>'> update </a> 
      </td>
        <td>
         <form:form action="/delete/employee/${employee.getId()}" method="delete">
         <input type="submit" value="Delete" class="btn btn-danger">
         </form:form>
      </td>
      </tr>
  
  </c:forEach>

   </tbody>
   </table>
    </div>        
<!-- end table three -->

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
        <script src="/main.js" ></script>
    </body>
    </html>