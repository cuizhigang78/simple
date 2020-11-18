package tk.mybatis.simple.mapper;

import tk.mybatis.simple.model.SysPrivilege;

import java.util.List;

/**
 * @ClassName PrivilegeMapper
 * @Author Maxwell
 * @Date 2020/11/13 23:27
 * @Description PrivilegeMapper
 * @Version 1.0
 */
public interface PrivilegeMapper {

    List<SysPrivilege> selectAll();
}
