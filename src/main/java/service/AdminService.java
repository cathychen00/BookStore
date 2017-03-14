package service;

import common.ShopException;
import dao.BookDAO;
import model.Book;

/**
 * Created by 陈敬 on 2017/3/14.
 */
public class AdminService {
    private BookDAO bookDAO=new BookDAO();

    private static AdminService adminService;

    public static AdminService getInstance() {
        if (adminService == null) {
            adminService = new AdminService();
        }
        return adminService;
    }

    public void add(Book book){
        boolean exist=bookDAO.findByName(book.getName())!=null;
        if(exist){
            throw new ShopException("该书名已存在");
        }
        bookDAO.add(book);
    }
}
