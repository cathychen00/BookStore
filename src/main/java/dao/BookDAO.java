package dao;

import model.Book;
import rowParser.BookParser;

/**
 * Created by 陈敬 on 2017/3/14.
 */
public class BookDAO {

    BookParser bookParser=new BookParser();

    public void add(Book book) {
        String sql = "insert into books(name,author,publisher,price) values(?,?,?,?)";

        int key = DBUtil.updateWithAutoGen(sql, book.getName(), book
                .getAuthor(), book.getPublisher(), book.getPrice());
        book.setId(key);
    }

    public Book findByName(String name) {
        String sql = "select id,name,author,publisher,price from books where name=?";
        return (Book) DBUtil.unique(sql, bookParser, name);
    }
}
