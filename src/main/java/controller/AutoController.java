package controller;

import dto.AutoDTO;
import dto.*;

import service.imp.AutoServiceImp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;


import exception.DAOException;



import service.imp.OpcionalesServiceImp;
import service.imp.VentaServiceImp;

import java.util.ArrayList;



public class AutoController extends HttpServlet {

    private AutoServiceImp autoService;
    private VentaServiceImp ventaService;
    private OpcionalesServiceImp opcionService;

    public AutoController() {

        this.autoService = new AutoServiceImp();
        this.ventaService = new VentaServiceImp();
        this.opcionService = new OpcionalesServiceImp();

    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        try {
            this.autoService.borrarAuto(id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Integer id = Integer.parseInt(req.getParameter("id"));
        Integer precio = null;
        try {


            precio = this.autoService.precioxAuto(id);
        }
        catch (DAOException e) {
            e.printStackTrace();
        }

        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");
        pw.println("<html><head>");
        pw.println("<TITLE>Servlet Curso Java Metodo GET</TITLE>");
        pw.println("</head><body>");
        pw.println("<h1>Precio de auto</h1>");
        pw.println("<h2>Para el auto con Id " + id + " tiene un precio de " + precio + "</h2>");
        pw.println("</body></html>");
        pw.close();
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        AutoDTO autoDTO = new AutoDTO();
        VentaDTO ventaDTO = new VentaDTO();
        this.autoService.setAuto(autoDTO);

        //asignamos variante
        ventaDTO.setIdAuto(Integer.parseInt(req.getParameter("idmodelo")));

        OpcionalesDTO opcionalesDTO = null;
        ArrayList<OpcionalesDTO> opcionales = new ArrayList<>();
        try {
            opcionalesDTO = this.opcionService.consultarOpcionales(Integer.parseInt(req.getParameter("opcional")));
        } catch (DAOException e) {
            e.printStackTrace();
        }

        opcionales.add(opcionalesDTO);

        try {
            ventaDTO.setPrecioFinal(ventaService.calculoPrecioFinal());
        } catch (DAOException e) {
            e.printStackTrace();
        }

        ventaService.ingresarVenta(ventaDTO);

    }



    public VentaServiceImp getVarianteService() {
        return ventaService;
    }


    public OpcionalesServiceImp getOpcionService() {
        return opcionService;
    }

    public void setOpcionService(OpcionalesServiceImp opcionService) {
        this.opcionService = opcionService;
    }

    public AutoServiceImp getAutoService() {
        return autoService;
    }

    public void setAutoService(AutoServiceImp autoService) {
        this.autoService = autoService;
    }


}
