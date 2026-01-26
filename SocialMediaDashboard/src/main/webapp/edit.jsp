<%@ page import="model.Post" %>
<html>
<head>
    <title>Edit Post</title>
</head>
<body>

<%
    Post post = (Post) request.getAttribute("post");
%>

<form action="SocialServlet" method="post">
    <textarea name="content"><%= post.getContent() %></textarea><br>
    <input type="hidden" name="id" value="<%= post.getId() %>">
    <input type="hidden" name="action" value="update">
    <button type="submit">Update</button>
</form>

</body>
</html>
