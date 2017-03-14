package servlets.admin;

import model.Book;
import rowParser.BookParser;
import service.AdminService;
import servlets.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 陈敬 on 2017/3/14.
 */
public class BookAddServlet extends BaseServlet {
    AdminService service=AdminService.getInstance();

    protected void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = "/admin/bookList.action";
        Book book=(Book)populate(req, new Book());
        try{
            service.add(book);
            addMessage(req,"添加成功");
        }catch (Exception e){
            uri="/admin/BookAdd.jsp";
            addError(req,"添加书籍失败"+e.getMessage().toString());
        }
        req.getRequestDispatcher(uri).forward(req,resp);
    }
}
