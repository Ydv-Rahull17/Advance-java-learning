<%@ page import="java.util.*, model.Post" %>
<!DOCTYPE html>
<html>
<head>
<title>Social Media Dashboard</title>

<style>
body {
    font-family: Arial;
    background-image: url("images/blog-bg.png.png");
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    min-height: 100vh;
}

.container {
    width: 60%;
    margin: 40px auto;
    background: grey;
    padding: 20px;
    border-radius: 10px;
}

.post-box {
    background: pink;
    padding: 15px;
    margin-top: 15px;
    border-radius: 6px;
}

textarea {
    width: 100%;
    height: 80px;
}
</style>
</head>

<body>

<div class="container">

<h2>Create Post</h2>

<form action="SocialServlet" method="post">
    <textarea name="content" required></textarea><br><br>
    <input type="hidden" name="action" value="add">
    <button type="submit">Publish</button>
</form>

<hr>

<h2>All Posts</h2>

<%
List<Post> posts = (List<Post>) request.getAttribute("posts");

if (posts == null || posts.size() == 0) {
%>
    <p>No posts yet.</p>
<%
} else {
    for (Post p : posts) {
%>
    <div class="post-box">
        <p><b><%= p.getContent() %></b></p>
        <small>Published at: <%= p.getTime() %></small><br><br>

        <a href="SocialServlet?action=edit&id=<%=p.getId()%>">Edit</a> |
        <a href="SocialServlet?action=delete&id=<%=p.getId()%>">Delete</a>
    </div>
<%
    }
}
%>

</div>
</body>
</html>
