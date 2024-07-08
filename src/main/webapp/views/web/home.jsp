<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file = "/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home News Website</title>
</head>
<body>
    <a href="admin-home">Test admin role</a>
    <div class="row">
    <!-- Blog Entries Column -->
      <div class="col-md-8">
           <c:forEach items="${model}" var="news">
                <div class="card mb-4">
                  <img class="card-img-top" src="http://placehold.it/750x300" alt="Card image cap">
                  <div class="card-body">
                    <h2 class="card-title">${news.id}</h2>
                    <p class="card-text">${news.title}</p>
                  </div>
                  <div class="card-footer text-muted">
                    ${news.content}
                  </div>
                </div>
           </c:forEach>
      </div>
    </div>
    <!-- /.row -->
</body>
</html>