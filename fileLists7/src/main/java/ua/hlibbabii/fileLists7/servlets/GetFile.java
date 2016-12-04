package ua.hlibbabii.fileLists7.servlets;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetFile extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) {
        String fileName = req.getParameter("name");
        try
        {
            byte[] bytes = getFile(fileName);
            sendFile(resp, bytes, fileName);
        } catch (Exception ex)
        {
        }
    }
    
    byte[] getFile(String filename)
    {
        byte[] bytes = null;
        try
        {
            java.io.File file = new java.io.File(filename);
            FileInputStream fis = new FileInputStream(file);
            bytes = new byte[(int) file.length()];
            fis.read(bytes);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
          return bytes;
    }
    void sendFile(HttpServletResponse response, byte[] bytes, String name) throws IOException
    {
        ServletOutputStream stream = response.getOutputStream();
        
        response.setContentType("application/txt");
        response.addHeader("Content-Type", "application/txt");
        response.addHeader("Content-Disposition", "attachment;filename=\"" + name + "\"");
        response.setContentLength((int) bytes.length);
        response.flushBuffer();
        stream.write(bytes);
        stream.flush();
        stream.close();
        final String ext = "txt";
        response.setHeader("Content-Disposition", "attachment;filename=\"" + name + "." + ext + "\"");
    }
}
