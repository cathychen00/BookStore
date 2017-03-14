package servlets;

import common.ShopException;
import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 陈敬 on 2017/3/9.
 */
public class LoginServlet extends BaseServlet {
    UserService userService=new UserService();

    protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = "/common/bookList.action";

        User user = (User) populate(request, new User());
        request.setAttribute("user", user);

        boolean isAdmin = "admin".equals(request.getParameter("role"));
        try {
            user = userService.login(user);
            if (isAdmin && !user.isAdmin()) {
                throw new ShopException("无权作为管理员登陆");
            }
            if (isAdmin) {
                //todo:/admin/bookList.action
                uri = "/admin/bookList.action";
            }
            //设置登录用户session
            request.getSession().setAttribute("currentUser", user);
        } catch (ShopException e) {
            e.printStackTrace();
            uri = "/login.jsp";
            addError(request, e.getMessage());
        }
        request.getRequestDispatcher(uri).include(request, response);
    }
}
