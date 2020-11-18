package tk.mybatis.simple.model;

import lombok.Data;
import lombok.ToString;

/**
 * @ClassName SysPrivilege
 * @Author Maxwell
 * @Date 2020/11/16 8:38
 * @Description 权限表
 * @Version 1.0
 */
@Data
@ToString
public class SysPrivilege {
    /** 权限ID */
    private Long id;
    /** 权限名称 */
    private String privilegeName;
    /** 权限url */
    private String privilegeUrl;
}
