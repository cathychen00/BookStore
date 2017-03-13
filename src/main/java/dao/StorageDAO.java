package dao;

import model.Book;
import model.Storage;
import rowParser.RowParser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 陈敬 on 2017/3/13.
 */
public class StorageDAO {
    public List<Storage> findBookInStore(){
        String sql = "select  b.id as bookid, name,author,publisher,price,amount,inDate,s.id as sid"
                + " from   books b ,storages s"
                + " where b.id=s.bookId  and amount>0";

        List<Storage> storageList = DBUtil.query(sql, new RowParser() {

            public Object parseRow(ResultSet rs) throws SQLException {
                Storage s = new Storage();
                Book b = new Book();
                s.setBook(b);
                b.setId(rs.getInt("bookid"));
                b.setName(rs.getString("name"));
                b.setAuthor(rs.getString("author"));
                b.setPublisher(rs.getString("publisher"));
                b.setPrice(rs.getDouble("price"));

                s.setId(rs.getInt("sid"));
                s.setAmount(rs.getInt("amount"));
                s.setInDate(rs.getDate("inDate"));
                return s;
            }
        });

        return storageList;
    }
}
