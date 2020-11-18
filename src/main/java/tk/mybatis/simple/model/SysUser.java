package tk.mybatis.simple.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @ClassName SysUser
 * @Author Maxwell
 * @Date 2020/11/16 8:32
 * @Description 用户表
 * @Version 1.0
 */
@Data
@ToString
public class SysUser {
    /** 用户ID */
    private Long id;
    /** 用户名 */
    private String userName;
    /** 密码 */
    private String userPassword;
    /** 邮箱 */
    private String userEmail;
    /** 简介 */
    private String userInfo;
    /** 头像 */
    /** byte[]类型一般对应数据库的BLOB、LONGVARBINARY以及一些和二进制流有关的字段类型 */
    private Byte[] headImg;
    /** 创建时间 */
    private Date createTime;
}
