package ca.sait.week4lab_simplenotekeeper.servlets;

import ca.sait.week4lab_simplenotekeeper.model.Note;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author meron Seyoum
 */
public class NoteServlet extends HttpServlet {

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
        String query = request.getQueryString();

// read the file content in to separete line      
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String title = br.readLine();
        String contents = br.readLine();

        if (query != null && query.contains("edit")) {
// if edit populate and display in the form from the note javabeans

            Note note = new Note(title, contents);
            request.setAttribute("note", note);

            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        } else {
// display the file content to the view page

            Note note = new Note(title, contents);
            request.setAttribute("note", note);

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
        //file path      
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");

        String title = request.getParameter("title");
        String contents = request.getParameter("contents");
// print the title and content to the note txt then display it in the view page
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        pw.println(title);
        pw.println(contents);
        pw.close();

        Note note = new Note(title, contents);

        request.setAttribute("note", note);
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }
}
