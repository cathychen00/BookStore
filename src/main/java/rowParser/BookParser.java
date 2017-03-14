package rowParser;

import model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 陈敬 on 2017/3/14.
 */
public class BookParser implements RowParser {
    public Object parseRow(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("id"));
        book.setName(rs.getString("name"));
        book.setPublisher(rs.getString("publisher"));
        book.setAuthor(rs.getString("author"));
        book.setPrice(rs.getDouble("price"));
        return book;
    }
}
