package tk.mybatis.simple.mapper;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName UserMapper
 * @Author Maxwell
 * @Date 2020/11/13 23:27
 * @Description UserMapper
 * @Version 1.0
 */
public interface UserMapper {
    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    SysUser selectById(Long id);

    /**
     * 通过条件查询用户
     * @param user
     * @return
     */
    List<SysUser> selectByUser(SysUser user);

    /**
     * 通过条件查询用户-（where标签改进版）
     * @param user
     * @return
     */
    List<SysUser> selectByUser2(SysUser user);

    /**
     * 根据用户id集合查询(只有一个List)
     * @param idList
     * @return
     */
    List<SysUser> selectByIdList(List<Long> idList);

    /**
     * 根据用户id集合查询(只有一个数组)
     * @param idArray
     * @return
     */
    List<SysUser> selectByIdList1(Long[] idArray);

    /**
     * 根据用户id集合查询(只有一个collection)
     * @param collection
     * @return
     */
    List<SysUser> selectByIdList11(Collection collection);

    /**
     * 根据用户id集合查询(有多个参数)
     * @param idList
     * @return
     */
    List<SysUser> selectByIdList2(@Param("userName") String userName, @Param("idList") List<Long> idList);

    /**
     * 根据用户id集合查询 (参数是Map类型)
     * @param map
     * @return
     */
    List<SysUser> selectByIdList3(Map<String, Object> map);

    /**
     * 根据id或用户名查询
     * @param sysUser
     * @return
     */
    SysUser selectByIdOrUserName(SysUser sysUser);

    /**
     * 查询全部用户
     * @return
     */
    List<SysUser> selectAll();

    /**
     * 获取用户角色
     * @param userId
     * @return
     */
    List<SysRole> selectRolesByUserId(Long userId);

    /**
     * 根据用户id和角色的enable状态获取用户的角色
     * @param
     * @return
     */
    List<SysRole> selectRolesByUserIdAndRoleEnabled(@Param("userId") Long userId,
                                                    @Param("enabled") Integer enabled);

    /**
     * 根据用户id和角色的enable状态获取用户的角色
     * @param
     * @return
     */
    List<SysRole> selectRolesByUserAndRole(@Param("user") SysUser user,
                                           @Param("role") SysRole role);

    /**
     * 新增用户
     * @param user
     * @return
     */
    int insert(SysUser user);

    /**
     * 新增用户-使用useGeneratedKeys返回自增主键
     * @param user
     * @return
     */
    int insert2(SysUser user);

    /**
     * 新增用户-使用selectKey返回自增主键
     * @param user
     * @return
     */
    int insert3(SysUser user);

    /**
     * 新增用户-选择性插入
     * @param user
     * @return
     */
    int insertSelective(SysUser user);

    /**
     * 批量插入用户信息
     * @param users
     * @return
     */
    int insertList(List<SysUser> users);

    /**
     * 批量插入用户信息(返回主键，需要MyBatis3.3.1及以上)
     * @param users
     * @return
     */
    int insertList2(List<SysUser> users);

    /**
     * 根据主键更新
     * @param sysUser
     * @return
     */
    int updateById(SysUser sysUser);

    /**
     * 根据主键更新
     * 一般情况下，MyBatis中选择性更新的方法名会以Selective作为后缀
     * @param sysUser
     * @return
     */
    int updateByIdSelective(SysUser sysUser);

    /**
     * 根据主键更新（set标签改进版）
     * 一般情况下，MyBatis中选择性更新的方法名会以Selective作为后缀
     * @param sysUser
     * @return
     */
    int updateByIdSelective2(SysUser sysUser);

    /**
     * 通过Map更新列
     * 这里没有通过@Param注解指定参数名，因而MyBatis内部的上下文中使用了默认的_Parameter作为该参数的key，
     * 所以在XML中也使用了_parameter。
     *
     * @param map
     * @return
     */
    int updateByMap(Map<String, Object> map);

    int updateByMap2(@Param("map") Map<String, Object> map);

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 根据主键删除
     * @param sysUser
     * @return
     */
    int deleteById(SysUser sysUser);
}
