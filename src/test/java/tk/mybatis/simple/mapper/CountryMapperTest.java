package tk.mybatis.simple.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tk.mybatis.simple.model.Country;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @ClassName CountryMapperTest
 * @Author Maxwell
 * @Date 2020/11/14 20:33
 * @Description CountryMapperTest
 * @Version 1.0
 */
public class CountryMapperTest extends BaseMapperTest {

    /**
     * 1. 通过Resources工具类将mybatis-config.xml配置文件读入Reader。
     * 2. 再通过SqlSessionFactoryBuilder建造类使用Reader创建sqlSessionFactory工厂对象。在创建sqlSessionFactory
     *    对象的过程中，首先解析mybatis-config.xml配置文件，读取配置文件中的mappers配置后会读取全部的Mapper.xml进行
     *    具体方法的解析，在这些解析完成后，sqlSessionFactory就包含了所有的属性配置和执行SQL的信息。
     * 3. 使用sqlSessionFactory工厂对象获取一个SqlSession对象。
     * 4. 通过SqlSession的selectList方法找到CountryMapper.xml中id="selectAll"的方法，执行SQL查询。
     * 5. MyBatis底层使用JDBC执行SQL，获取查询结果集ResultSet后，根据resultType的配置将结果映射为Country类型的集合，
     *    返回查询结果。
     * 6. 这样就提到了最后的查询结果countryList，简单将结果输出到控制台。
     * 7. 最后一定不要忘关闭SqlSession，否则会加为连接没有关闭导致数据库连接数过多，造成系统崩溃。
     */
    @Test
    public void testSelectAll() {
        SqlSession sqlSession = getSqlSession();
        try {
            // List<Country> list = sqlSession.selectList("selectAll");
            // 由于UserMapper中添加了一个selectAll方法，因此CountryMapperTest中的selectAll不再唯一
            // 调用时必须带上namespace
            List<Country> list = sqlSession.selectList("tk.mybatis.simple.mapper.CountryMapper.selectAll");
            printCountryList(list);
        } finally {
            sqlSession.close();
        }
    }

    private void printCountryList(List<Country> list) {
        for (Country country : list) {
            System.out.printf("%-4d%4s%4s\n", country.getId(), country.getCountryname(), country.getCountrycode());
        }
    }
}
