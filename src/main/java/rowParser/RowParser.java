package rowParser;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 陈敬 on 2017/3/9.
 */
public interface RowParser {
    //数据行转换为实体
    Object parseRow(ResultSet set) throws SQLException;
}
