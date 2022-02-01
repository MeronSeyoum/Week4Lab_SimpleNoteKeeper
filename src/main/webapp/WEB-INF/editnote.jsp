<%-- 
    Document   : editnote
    Created on : 1-Feb-2022, 11:35:18 AM
    Author     : Meron Seyoum
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note Page</title>
    </head>
    <body>
         <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        
        <form action="note" method="post">
            <label for="title">Title: </label>
            <input type="text" name="title" id="title" placeholder="Title" value="${note.title}">
            <br><br>
            <label for="contents">Contents: </label>
            <textarea name="contents" id="contents" placeholder="Contents" rows="4" cols="50">${note.contents}</textarea>
            <br><br>
            <button type="submit">Save</button>
        </form>
    </body>
</html>
