package edu.hlibbabii.points26.servlets;

import edu.hlibbabii.points26.service.Logic;
import edu.hlibbabii.points26.service.Point;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 *
 * @author Hlib Babii <hlib.babii at hlibbabii.ua>
 */
public class FindPoints extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Logic logic = new Logic();
        logic.setCenterX(Integer.parseInt(request.getParameter("x")));
        logic.setCenterY(Integer.parseInt(request.getParameter("y")));
        logic.setRadius1(Integer.parseInt(request.getParameter("radius1")));
        logic.setRadius2(Integer.parseInt(request.getParameter("radius2")));
        logic.setRadius3(Integer.parseInt(request.getParameter("radius3")));
        logic.setRadius4(Integer.parseInt(request.getParameter("radius4")));
        logic.setRadius5(Integer.parseInt(request.getParameter("radius5")));
        Collection<Point> points = logic.compureCircle();
        request.getSession().setAttribute("points", points);
        request.getSession().setAttribute("circleNum", logic.getCircleNum());
        response.sendRedirect("result.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
