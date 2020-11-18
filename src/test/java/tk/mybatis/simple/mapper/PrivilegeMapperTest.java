package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.simple.model.SysPrivilege;
import tk.mybatis.simple.proxy.MyMapperProxy;

import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @ClassName PrivilegeMapperTest
 * @Author Maxwell
 * @Date 2020/11/18 8:38
 * @Description PrivilegeMapperTest
 * @Version 1.0
 */
public class PrivilegeMapperTest extends BaseMapperTest {
    @Test
    public void testSelectAll() {
        SqlSession sqlSession = getSqlSession();

        MyMapperProxy<PrivilegeMapper> privilegeMapperProxy = new MyMapperProxy<PrivilegeMapper>(PrivilegeMapper.class, sqlSession);

        PrivilegeMapper privilegeMapper = (PrivilegeMapper) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{PrivilegeMapper.class}, privilegeMapperProxy);

        List<SysPrivilege> sysPrivileges = privilegeMapper.selectAll();

        Assert.assertNotNull(sysPrivileges);
        Assert.assertEquals(5, sysPrivileges.size());
    }
}
