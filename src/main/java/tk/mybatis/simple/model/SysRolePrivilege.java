package tk.mybatis.simple.model;

import lombok.Data;

/**
 * @ClassName SysRolePrivilege
 * @Author Maxwell
 * @Date 2020/11/16 8:39
 * @Description 角色权限关联表
 * @Version 1.0
 */
@Data
public class SysRolePrivilege {
    /** 角色ID */
    private Long roleId;
    /** 权限ID */
    private Long privilegeId;
}
