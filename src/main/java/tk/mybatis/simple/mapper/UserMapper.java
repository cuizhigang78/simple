package tk.mybatis.simple.mapper;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

import java.util.List;

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
     * 根据主键更新
     * @param sysUser
     * @return
     */
    int updateById(SysUser sysUser);

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
