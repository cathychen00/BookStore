package rowParser;

import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 陈敬 on 2017/3/9.
 */
public class UserParser implements RowParser {
    public Object parseRow(ResultSet set) throws SQLException {
        User user=new User();
        user.setId(set.getInt("id"));
        user.setName(set.getString("name"));
        user.setPasswd(set.getString("passwd"));
        user.setSex(set.getString("sex"));
        user.setAge(set.getInt("age"));
        user.setAddress(set.getString("address"));
        user.setPhone(set.getString("phone"));
        user.setAdmin(set.getBoolean("adm"));
        return user;
    }
}
