package service;

import common.ShopException;
import dao.UserDAO;
import model.User;

/**
 * Created by 陈敬 on 2017/3/9.
 */
public class UserService {
    private UserDAO userDAO=new UserDAO();


    public User login(User user) {
        User model=userDAO.findByName(user.getName());
        if(model==null){
            throw new ShopException("用户名不存在");
        }
        if(model.getPasswd()!=null&&!model.getPasswd().equals(user.getPasswd())){
            throw  new ShopException("密码不正确");
        }else{
            return model;
        }
    }
}
