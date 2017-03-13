package service;

import dao.StorageDAO;
import model.Storage;

import java.util.List;

/**
 * Created by 陈敬 on 2017/3/13.
 */
public class CustomerService {
    private StorageDAO storageDAO=new StorageDAO();

    //获取书籍库存信息
    public List<Storage> listStores() {

        return storageDAO.findBookInStore();
    }
}
