/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ca.sait.week4lab_simplenotekeeper.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author merya
 */
public class NoteServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operator = request.getParameter("operator");
        request.setAttribute("note", readNote());
        if (operator != null && operator.equals("operator")) {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);

        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//variables
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        if (title == null || title.equals("") || content == null || content.equals("")) {
            request.setAttribute("title", title);
            request.setAttribute("content", content);
            request.setAttribute("invalid", true);

            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        } else {
           
            writeNote(title, content);
            request.setAttribute("note", readNote());
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        }
    }

   
}
