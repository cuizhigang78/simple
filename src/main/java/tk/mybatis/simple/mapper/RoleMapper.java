package tk.mybatis.simple.mapper;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cache.decorators.FifoCache;
import tk.mybatis.simple.model.SysRole;

/**
 * @ClassName RoleMapper
 * @Author Maxwell
 * @Date 2020/11/13 23:27
 * @Description RoleMapper
 * @Version 1.0
 */
@CacheNamespaceRef(RoleMapper.class)
public interface RoleMapper {

    /**
     * 通过id查询角色
     * @param id
     * @return
     */
    @Select({"select * from sys_role where id = #{id}"})
    SysRole selectById(Long id);

    /**
     * 更新
     * @param role
     * @return
     */
    int updateById(SysRole role);
}
