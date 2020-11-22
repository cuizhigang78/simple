package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.simple.model.SysUser;

/**
 * @ClassName CacheTest
 * @Author Maxwell
 * @Date 2020/11/22 21:47
 * @Description CacheTest
 * @Version 1.0
 */
public class CacheTest extends BaseMapperTest {
    /**
     * MyBatis的一级缓存存在于SqlSession的生命周期中，在同一个SqlSession中查询时，
     * MyBatis会把执行的方法和参数通过算法生成缓存的键值，将键值和查询结果存入一个
     * Map对象中。如果同一个SqlSession中执行的方法和参数完全一致，那么通过算法会生成
     * 相同的键值，此时查询则会直接返回Map中的对象则不是访问数据库。
     *
     * 修改Mapper.xml，增加flushCache="true"属性，表示在执行查询前会清空当前的一缓存。
     * 同时，任何INSERT、UPDATE、DELETE操作都会清空一级缓存，所以user3 != user2
     *
     */
    @Test
    public void testL1Cache() {
        // 获取SqlSession
        SqlSession sqlSession = getSqlSession();
        SysUser user1 = null;
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 查询id=1的用户
            user1 = userMapper.selectById(1L);
            // 重新赋值userName
            user1.setUserName("New Name");
            // 再次查询
            SysUser user2 = userMapper.selectById(1L);
            // 虽然没有更新数据库，但是这个user2.userName == user1.userName
            Assert.assertEquals("New Name", user2.getUserName());
            Assert.assertEquals(user1.getUserName(), user2.getUserName());
            Assert.assertEquals(user1, user2);
        } finally {
            // 关闭当前SqlSession
            sqlSession.close();
        }
        System.out.println("开启新的sqlSession");
        sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 再次查询
            SysUser user2 = userMapper.selectById(1L);
            // 此时user2 != user1
            Assert.assertNotEquals(user1, user2);
            // 执行删除操作
            userMapper.deleteById(2L);
            // 获取user3
            SysUser user3 = userMapper.selectById(1L);
            // user2 != user3
            Assert.assertNotEquals(user2, user3);
        } finally {
            // 关闭当前SqlSession
            sqlSession.close();
        }
    }
}
