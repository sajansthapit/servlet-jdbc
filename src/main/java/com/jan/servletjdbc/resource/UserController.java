package com.jan.servletjdbc.resource;

import com.jan.servletjdbc.config.ConnectionFactory;
import com.jan.servletjdbc.domain.User;
import com.jan.servletjdbc.dto.ResponseDto;
import com.jan.servletjdbc.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

@WebServlet("/user")
public class UserController extends HttpServlet {

    private static final long serialVersionUID = 102831973239L;


    private static final Logger log = Logger.getLogger(UserController.class.getName());

    private UserService userService;

    private RequestDispatcher requestDispatcher = null;

    @Override
    public void init() throws ServletException{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try {
            this.userService = new UserService(connectionFactory);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        User user = new User();
        user.setUsername(request.getParameter("userName"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setGender(request.getParameter("gender"));

        try {
            ResponseDto result = userService.saveUser(user);
            if (result.isSuccess()) {
                requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(request, response);
            }
        } catch (Exception e) {
            log.info("message:: " + e.getMessage());
        }
    }

}



  /*  private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        if(employeeDAO.delete(Integer.parseInt(id))) {
            request.setAttribute("NOTIFICATION", "Employee Deleted Successfully!");
        }

        listEmployee(request, response);
    }

    private void getSingleEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String id = request.getParameter("id");

        Employee theEmployee = employeeDAO.get(Integer.parseInt(id));

        request.setAttribute("employee", theEmployee);

        dispatcher = request.getRequestDispatcher("/views/employee-form.jsp");

        dispatcher.forward(request, response);
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Employee> theList = employeeDAO.get();

        request.setAttribute("list", theList);

        dispatcher = request.getRequestDispatcher("/views/employee-list.jsp");

        dispatcher.forward(request, response);
    }*/
