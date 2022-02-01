<%-- 
    Document   : viewnote
    Created on : 1-Feb-2022, 11:34:35 AM
    Author     : meron Seyoum
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Note Page</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <label for="title">Title:&nbsp; ${note.title}</lable>
        <br><br>
        <label for="contents">Contents:<br>${note.contents}</lable>
        <br><br>
        <a href="note?edit">Edit</a>
    </body>
</html>
