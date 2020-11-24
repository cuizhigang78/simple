package tk.mybatis.simple.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName SysRole
 * @Author Maxwell
 * @Date 2020/11/16 8:36
 * @Description 角色表
 * @Version 1.0
 */
@Data
@ToString
public class SysRole implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 用户信息 */
    private SysUser user;
    /** 角色ID */
    private Long id;
    /** 角色名称 */
    private String roleName;
    /** 有效标志 */
    private Integer enabled;
    /** 创建人 */
    private Long createBy;
    /** 创建时间 */
    private Date createTime;
}
