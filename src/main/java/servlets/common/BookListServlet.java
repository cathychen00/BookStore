package servlets.common;

import model.Storage;
import service.CustomerService;
import servlets.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by 陈敬 on 2017/3/13.
 */
public class BookListServlet extends BaseServlet {
    CustomerService customerService=new CustomerService();
    protected void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Storage> storages=customerService.listStores();
        req.setAttribute("storages",storages);
        req.getRequestDispatcher("/common/BookList.jsp").include(req, resp);
    }
}
