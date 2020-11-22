package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.simple.model.SysRole;

/**
 * @ClassName RoleMapperTest
 * @Author Maxwell
 * @Date 2020/11/19 7:56
 * @Description RoleMapperTest
 * @Version 1.0
 */
public class RoleMapperTest extends BaseMapperTest {

    @Test
    public void testSelectById() {
        SqlSession sqlSession = getSqlSession();
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole sysRole = roleMapper.selectById(1L);
            Assert.assertNotNull(sysRole);
            System.out.println(sysRole);
        } finally {
            sqlSession.close();
        }
    }
}
