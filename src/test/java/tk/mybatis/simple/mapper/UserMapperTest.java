package tk.mybatis.simple.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

import java.io.IOException;
import java.io.Reader;
import java.util.*;

/**
 * @ClassName UserMapperTest
 * @Author Maxwell
 * @Date 2020/11/14 20:33
 * @Description UserMapperTest
 * @Version 1.0
 */
public class UserMapperTest extends BaseMapperTest {

    @Test
    public void testSelectById() {
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 调用selectById，查询id = 1 的用户
            SysUser user = userMapper.selectById(1L);
            // user不为空
            Assert.assertNotNull(user);
            // userName = admin
            Assert.assertEquals("admin", user.getUserName());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectByUser() {
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser userParam = new SysUser();
            userParam.setUserName("t");
            userParam.setUserEmail("admin@mybatis.tk");
            List<SysUser> users = userMapper.selectByUser(userParam);
            // user不为空
            Assert.assertNotNull(users);
            for (SysUser user : users) {
                System.out.println(user);
            }
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectByUser2() {
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser userParam = new SysUser();
            userParam.setUserName("t");
            userParam.setUserEmail("admin@mybatis.tk");
            List<SysUser> users = userMapper.selectByUser2(userParam);
            // user不为空
            Assert.assertNotNull(users);
            for (SysUser user : users) {
                System.out.println(user);
            }
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectByIdOrUserName() {
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // id和userName都按，只根据id查询时
            SysUser query = new SysUser();
            query.setId(1L);
            query.setUserName("admin");
            SysUser user = userMapper.selectByIdOrUserName(query);
            Assert.assertNotNull(user);
            // 当没有id时，根据userName查询
            query.setId(null);
            user = userMapper.selectByIdOrUserName(query);
            Assert.assertNotNull(user);
            // 当id和userName都为空时，无结果
            query.setUserName(null);
            user = userMapper.selectByIdOrUserName(query);
            Assert.assertNotNull(user);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectByIdList() {
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<Long> idList = new ArrayList<Long>();
            idList.add(1L);
            idList.add(1001L);
            List<SysUser> users = userMapper.selectByIdList(idList);
            Assert.assertEquals(2, users.size());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectByIdList1() {
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Long[] idArray = new Long[] {1L, 1001L};
            List<SysUser> users = userMapper.selectByIdList1(idArray);
            Assert.assertEquals(2, users.size());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectByIdList11() {
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Set<Long> idSet = new HashSet<Long>();
            idSet.add(1L);
            idSet.add(1001L);
            List<SysUser> users = userMapper.selectByIdList11(idSet);
            Assert.assertEquals(2, users.size());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectByIdList2() {
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<Long> idList = new ArrayList<Long>();
            idList.add(1L);
            idList.add(1001L);
            List<SysUser> users = userMapper.selectByIdList2("admin", idList);
            Assert.assertEquals(1, users.size());
            Assert.assertEquals("admin", users.get(0).getUserName());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectByIdList3() {
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Object> map = new HashMap<String, Object>();
            List<Long> idList = new ArrayList<Long>();
            idList.add(1L);
            idList.add(1001L);
            map.put("idList", idList);
            List<SysUser> users = userMapper.selectByIdList3(map);
            Assert.assertEquals(2, users.size());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 调用selectById，查询id = 1 的用户
            List<SysUser> users = userMapper.selectAll();
            for (SysUser user : users) {
                System.out.println(user);
            }
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRolesByUserId() {
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysRole> roles = userMapper.selectRolesByUserId(1L);
            for (SysRole role : roles) {
                System.out.println(role);
            }
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testInsert() {
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.tk");
            user.setUserInfo("test info");
            user.setHeadImg(new Byte[]{1, 2, 3});
            user.setCreateTime(new Date());
            // 将新建的对象插入数据库中，特别注意这里的返回值result是执行的SQL影响的行数
            int count = userMapper.insert(user);
            Assert.assertEquals(1, count);
            // id为null，因为没有给id赋值，并且没有配置回写id的值
            Assert.assertNotNull(user.getId());
        } finally {
            // 为了不影响其他测试，这里选择回滚
            // 由于默认的sqlSessionFactory.openSession()是不自动提交的
            // 因为不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testInsert2() {
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.tk");
            user.setUserInfo("test info");
            user.setHeadImg(new Byte[]{1, 2, 3});
            user.setCreateTime(new Date());
            // 将新建的对象插入数据库中，特别注意这里的返回值result是执行的SQL影响的行数
            int count = userMapper.insert2(user);
            Assert.assertEquals(1, count);
            Assert.assertNotNull(user.getId());
        } finally {
            // 为了不影响其他测试，这里选择回滚
            // 由于默认的sqlSessionFactory.openSession()是不自动提交的
            // 因为不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testInsertSelective() {
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserInfo("test info");
            user.setHeadImg(new Byte[]{1, 2, 3});
            user.setCreateTime(new Date());
            // 将新建的对象插入数据库中，特别注意这里的返回值result是执行的SQL影响的行数
            int count = userMapper.insertSelective(user);
            // 获取插入的这条数据
            user = userMapper.selectById(user.getId());
            Assert.assertEquals("test@mybatis.tk", user.getUserEmail());
        } finally {
            // 为了不影响其他测试，这里选择回滚
            // 由于默认的sqlSessionFactory.openSession()是不自动提交的
            // 因为不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testInsert3() {
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.tk");
            user.setUserInfo("test info");
            user.setHeadImg(new Byte[]{1, 2, 3});
            user.setCreateTime(new Date());
            // 将新建的对象插入数据库中，特别注意这里的返回值result是执行的SQL影响的行数
            int count = userMapper.insert3(user);
            Assert.assertEquals(1, count);
            Assert.assertNotNull(user.getId());
        } finally {
            // 为了不影响其他测试，这里选择回滚
            // 由于默认的sqlSessionFactory.openSession()是不自动提交的
            // 因为不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testInsertList() {
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            ArrayList<SysUser> users = new ArrayList<SysUser>();
            for (int i = 0; i < 2; i++) {
                users.add(SysUser.builder()
                        .userName("test" + i)
                        .userPassword("123456")
                        .userEmail("test@mybatis.tk")
                        .build())
                ;
            }
            // 将新建的对象插入数据库中，特别注意这里的返回值result是执行的SQL影响的行数
            int count = userMapper.insertList(users);
            for (SysUser user : users) {
                // null
                System.out.println(user.getId());
            }
            Assert.assertEquals(2, count);
        } finally {
            // 为了不影响其他测试，这里选择回滚
            // 由于默认的sqlSessionFactory.openSession()是不自动提交的
            // 因为不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testInsertList2() {
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            ArrayList<SysUser> users = new ArrayList<SysUser>();
            for (int i = 0; i < 2; i++) {
                users.add(SysUser.builder()
                        .userName("test" + i)
                        .userPassword("123456")
                        .userEmail("test@mybatis.tk")
                        .build())
                ;
            }
            // 将新建的对象插入数据库中，特别注意这里的返回值result是执行的SQL影响的行数
            int count = userMapper.insertList2(users);
            for (SysUser user : users) {
                // 1010
                // 1011
                System.out.println(user.getId());
            }
            Assert.assertEquals(2, count);
        } finally {
            // 为了不影响其他测试，这里选择回滚
            // 由于默认的sqlSessionFactory.openSession()是不自动提交的
            // 因为不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testUpdateById() {
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = userMapper.selectById(1L);
            Assert.assertEquals("admin", user.getUserName());
            user.setUserName("admin_test");
            user.setUserEmail("test@mybatis.tk");
            // SQL影响的行数
            int count = userMapper.updateById(user);
            Assert.assertEquals(1, count);
            user = userMapper.selectById(1L);
            Assert.assertEquals("admin_test", user.getUserName());
            Assert.assertEquals("test@mybatis.tk", user.getUserEmail());
        } finally {
            // 为了不影响其他测试，这里选择回滚
            // 由于默认的sqlSessionFactory.openSession()是不自动提交的
            // 因为不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testUpdateByIdSelective() {
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setId(1L);
            // SQL影响的行数
            int count = userMapper.updateByIdSelective(user);
            user = userMapper.selectById(1L);
            System.out.println(user);
        } finally {
            // 为了不影响其他测试，这里选择回滚
            // 由于默认的sqlSessionFactory.openSession()是不自动提交的
            // 因为不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testUpdateByIdSelective2() {
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setId(1L);
            // SQL影响的行数
            int count = userMapper.updateByIdSelective2(user);
            user = userMapper.selectById(1L);
            System.out.println(user);
        } finally {
            // 为了不影响其他测试，这里选择回滚
            // 由于默认的sqlSessionFactory.openSession()是不自动提交的
            // 因为不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testUpdateByMap() {
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("id", 1L);
            map.put("user_email", "test@mybatis.tk");
            map.put("user_password", "12345678");
            userMapper.updateByMap(map);
            SysUser user = userMapper.selectById(1L);
            Assert.assertEquals("test@mybatis.tk", user.getUserEmail());
        } finally {
            // 为了不影响其他测试，这里选择回滚
            // 由于默认的sqlSessionFactory.openSession()是不自动提交的
            // 因为不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testDeleteById() {
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // SQL影响的行数
            int count = userMapper.deleteById(1001L);
            Assert.assertEquals(1, count);
            Assert.assertNull(userMapper.selectById(1001L));

            SysUser user = userMapper.selectById(1L);
            count = userMapper.deleteById(user);
            Assert.assertEquals(1, count);
            Assert.assertNull(userMapper.selectById(1L));

        } finally {
            // 为了不影响其他测试，这里选择回滚
            // 由于默认的sqlSessionFactory.openSession()是不自动提交的
            // 因为不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRolesByUserIdAndRoleEnabled() {
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 当不使用@Param注解时：
            // Cause: org.apache.ibatis.binding.BindingException: Parameter 'userId' not found. Available parameters are [0, 1, param1, param2]
            // 这个错误表示，XML可用的参数只有0、1、param1、param2（都是MyBatis自定义的名字），而没有userId，如果此时将XML中的#{userId}改为#{0}，这个方法
            // 就能正常被调用了。

            // 当使用@Param注解后：MyBatis就会自动将参数封闭成Map类型，@Param注解值会作为Map的key。
            List<SysRole> sysRoles = userMapper.selectRolesByUserIdAndRoleEnabled(1L, 1);
            Assert.assertNotNull(sysRoles);
            Assert.assertTrue(sysRoles.size() > 0);
        } finally {
            // 为了不影响其他测试，这里选择回滚
            // 由于默认的sqlSessionFactory.openSession()是不自动提交的
            // 因为不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRolesByUserAndRole() {
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysUser sysUser = userMapper.selectById(1L);
            SysRole sysRole = roleMapper.selectById(1L);
            List<SysRole> sysRoles = userMapper.selectRolesByUserAndRole(sysUser, sysRole);
            Assert.assertNotNull(sysRoles);
            Assert.assertTrue(sysRoles.size() > 0);
        } finally {
            // 为了不影响其他测试，这里选择回滚
            // 由于默认的sqlSessionFactory.openSession()是不自动提交的
            // 因为不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }
}
