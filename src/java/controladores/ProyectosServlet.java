/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "ProyectosServlet", urlPatterns = {"/ProyectosServlet"})
public class ProyectosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Proyecto proyecto=new Proyecto();
        String action = request.getParameter("action");
        response.setContentType("application/json");
        
            Gson gson = new Gson();
            Usuario[] usuarios = new Usuario().getUsuarios();
            PrintWriter out = response.getWriter();
            out.print(gson.toJson(usuarios));  
            out.flush();
            String nombre = request.getParameter("inputNombre");
            String descripcion=request.getParameter("inputDescripcion");
            String id=request.getParameter("inputId");
            Integer  id_usuario=Integer.valueOf(id);
            String id_proy = request.getParameter("Id");
            if (action.equals("guardar")){ 
                
                proyecto.guardar(nombre,descripcion,id_usuario);
            }
            if (action.equals("actualizar")){ 
                
                proyecto.update(id_proy, nombre, descripcion, id);
            }
            if (action.equals("eliminar")){ 
                
                
                proyecto.eliminar(request.getParameter("Id"));
            }
            
          
        

        
    }

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
        processRequest(request, response);
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
