<%-- 
    Document   : nviewnote
    Created on : 1-Feb-2022, 11:34:35 AM
    Author     : merya
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
        <label for="title">Title:</lable>
        <p name="title" id="title">${note.title}</p>
        <label for="contents">Contents:</lable>
        <p name="contents" id="contents"><br>${note.contents}</p>
        <a href="note?edit">Edit</a>
    </body>
</html>
