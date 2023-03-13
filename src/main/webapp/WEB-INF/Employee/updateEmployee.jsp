<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    


    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Create Employee</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    </head>
    
    <body>
    
    <div class="container mt-5">
    
    <c:if test="${error != null}">
       <div class="alert alert-danger">
          <c:out  value="${error}" /> 
      </div>
    </c:if>

    <form:errors element="div" path="employee.*" cssClass="alert alert-danger"  />
    <form:form modelAttribute="employee" action="/employee/edit/${employee.id}" >
     <input type="hidden" name="_method" value="put">  
    
       <div class="mb-3">
        <label for="name" class="form-label">Employee Name : </label>
        <form:input path="name" type="text" cssClass="form-control" cssErrorClass="form-control is-invalid" id="name" aria-describedby="bookHelp" />
        <form:errors path="name" cssClass="invalid-feedback" />
      </div>
  
      <div class="mb-3">
        <label for="age" class="form-label">Employee Age  : </label>
        <form:input path="age" type="text" cssClass="form-control" cssErrorClass="form-control is-invalid" id="age" aria-describedby="bookHelp" />
        <form:errors path="age" cssClass="invalid-feedback" />
      </div>
      
      <div class="mb-3">
        <label for="skill" class="form-label">Skill : </label>
        <form:input path="skill" type="text" cssClass="form-control" cssErrorClass="form-control is-invalid" id="skill" aria-describedby="bookHelp" />
        <form:errors path="skill" cssClass="invalid-feedback" />
      </div>
      
      <div class="mb-3">   
        <label class="form-label">Status:</label>    
        <form:select path="status" cssClass="form-control" cssErrorClass="form-control is-invalid"> 
       
          <option value="" > Select Status </option>
    
             <form:option value="Active" label="Active"> 
               Active
             </form:option>
             
              <form:option value="inactive" label="inactive"> 
               inactive
             </form:option>

        </form:select>  
        <form:errors path="status" cssClass="text-danger"/>
       </div>
       
              <div class="mb-3">   
        <label class="form-label">Store:</label>    
        <form:select path="store" cssClass="form-control" cssErrorClass="form-control is-invalid" > 
       
          <option value="" > Select Store </option>
          <c:forEach var="store" items="${stores}">
             <form:option value="${store.id}" label=""> 
                 <c:out value="${store.name}" />
             </form:option>
          </c:forEach>
         
        </form:select>  
        <form:errors path="store" cssClass="text-danger"/>
       </div>
       
      
    <button type="submit" class="btn btn btn-success">Update</button>
   
    </form:form>
    
      <a  class="text-primary mt-5 mb-2" href='/dashboard'> <button class="btn btn-primary">Cancel</button></a> 
    </div>        


  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
        <script src="/main.js" ></script>
    </body>
    </html>