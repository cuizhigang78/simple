package tk.mybatis.simple.model;

import lombok.Data;

/**
 * @ClassName SysUserRole
 * @Author Maxwell
 * @Date 2020/11/16 8:35
 * @Description 用户角色关联表
 * @Version 1.0
 */
@Data
public class SysUserRole {
    /** 用户ID */
    private Long userId;
    /** 角色ID */
    private Long roleId;
}
