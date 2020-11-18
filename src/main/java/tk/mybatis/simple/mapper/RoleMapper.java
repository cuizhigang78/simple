package tk.mybatis.simple.mapper;

import tk.mybatis.simple.model.SysRole;

/**
 * @ClassName RoleMapper
 * @Author Maxwell
 * @Date 2020/11/13 23:27
 * @Description RoleMapper
 * @Version 1.0
 */
public interface RoleMapper {

    /**
     * 通过id查询角色
     * @param id
     * @return
     */
    SysRole selectById(Long id);
}
