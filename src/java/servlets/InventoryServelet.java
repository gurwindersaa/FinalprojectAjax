/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Item;
import models.User;
import services.UserServices;

/**
 *
 * @author gurwi
 */
public class InventoryServelet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserServices us = new UserServices();
        String email = "cprg352+anne@gmail.com";
//        try {
//            User users = us.get(email);
//            System.out.println("USers" + users.getEmail());
//            request.setAttribute("users", users);
//        } catch (Exception ex) {
//            Logger.getLogger(InventoryServelet.class.getName()).log(Level.SEVERE, null, ex);
//            request.setAttribute("message", "error");
//        }
        String action = request.getParameter("action");

        if (action == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/Inventory.jsp").forward(request, response);

        }

        try {
            switch (action) {
                case "getAll":
                    List<Item> items = us.getAll(email);
                    String itemJson = getItemJson(items);
                    response.getWriter().write(itemJson);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(InventoryServelet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    private String getItemJson(List<Item> items) {
        String json = "[";
        for (int i = 0; i < items.size(); i++) {
            if (i > 0) {
                json += ",\n";
            }
            json += getItemJson(items.get(i));
        }
        json += "]";
        return json;
    }

    private String getItemJson(Item item) {
        String json = "{\n";
        json += "\"id\":" + item.getItemId() + ",\n";
        json += "\"catagory\":\"" + item.getCategory().getCategoryName() + "\",\n";
        json += "\"name\":\"" + item.getItemName() + "\",\n";
        json += "\"price\":\"" + item.getPrice() + "\"\n";
        json += "}";
        return json;
        

    }
}
