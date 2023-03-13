<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    


    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Create Store</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    </head>
    
    <body>
    
    <div class="container mt-5">

     <c:if test="${success != null}">
       <div class="alert alert-success">
          <c:out  value="${success}" /> 
      </div>
    </c:if>
    
    <form:errors element="div" path="store.*" cssClass="alert alert-danger"  />
    <form:form method="post" modelAttribute="store">

      <div class="mb-3">
        <label for="name" class="form-label">Store Name : </label>
        <form:input path="name" type="text" cssClass="form-control" cssErrorClass="form-control is-invalid" id="name" aria-describedby="bookHelp" />
        <form:errors path="name" cssClass="invalid-feedback" />
      </div>
  
      <div class="mb-3">
        <label for="address" class="form-label">Address : </label>
        <form:input path="address" type="text" cssClass="form-control" cssErrorClass="form-control is-invalid" id="address" aria-describedby="bookHelp" />
        <form:errors path="address" cssClass="invalid-feedback" />
      </div>
      
      <div class="mb-3">
        <label for="store_type" class="form-label">Store Type : </label>
        <form:input path="store_type" type="text" cssClass="form-control" cssErrorClass="form-control is-invalid" id="store_type" aria-describedby="bookHelp" />
        <form:errors path="store_type" cssClass="invalid-feedback" />
      </div>
      
      <div class="mb-3">   
          <label for="status" class="form-label">Status:</label>    
          <form:select path="status" id="status" cssClass="form-control" cssErrorClass="form-control is-invalid" > 
             <option value="" > Select Status </option>
          
             <form:option value="Active" label="Active"> 
               Active
             </form:option>
             
              <form:option value="inactive" label="inactive"> 
               inactive
             </form:option>
             
          </form:select>  
          <form:errors path="status" cssClass="invalid-feedback"/>
       </div>
      
    <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>
      <a  class="text-primary" href='/dashboard'> <button type="submit" class="btn btn-primary">Back To Dashboard </button></a> 
    </div>        


  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
        <script src="/main.js" ></script>
    </body>
    </html>