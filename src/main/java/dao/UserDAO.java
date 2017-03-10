package dao;

import model.User;
import rowParser.*;

import java.util.List;

/**
 * Created by 陈敬 on 2017/3/9.
 */
public class UserDAO {
    public void add(User u) {
        String sql = "insert into users(name,passwd,sex,age,address,phone,adm) " + "values(?,?,?,?,?,?,?,?)";
        int key = DBUtil.updateWithAutoGen(sql, u.getName(), u.getPasswd(), u.getSex(), u.getAge(), u.getAddress(),
                u.getPhone(), u.isAdmin());
        u.setId(key);
    }

    public User findById(int id) {
        String sql = "select id,name,passwd,sex,age,address,phone,adm from users where id=?";
        User u = (User) DBUtil.unique(sql, new UserParser(), id);
        return u;
    }

    public User findByName(String name) {
        String sql = "select id,name,passwd,sex,age,address,phone,adm from users where name=?";
        User u = (User) DBUtil.unique(sql, new UserParser(), name);
        return u;
    }

    public List<User> list() {
        String sql = "select id,name,passwd,sex,age,address,postcode,phone,adm from users";
        return DBUtil.query(sql, new UserParser());
    }

    public void delete(int id) {
        DBUtil.update("delete users where id=?", id);
    }

    public void update(User u) {
        String sql = "update user set passwd=?,age=?,address=?,phone=?,sex=? where id=?";
        DBUtil.update(sql, u.getPasswd(), u.getAge(), u.getAddress(), u.getPhone(), u.getSex(), u.getId());
    }

    public void updatePasswd(int id, String passwd) {
        String sql = "update user set passwd=? where id=?";
        DBUtil.update(sql, passwd, id);
    }
}
