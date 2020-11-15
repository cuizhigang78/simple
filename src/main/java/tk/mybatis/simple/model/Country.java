package tk.mybatis.simple.model;

import lombok.Data;

/**
 * @ClassName Country
 * @Author Maxwell
 * @Date 2020/11/13 23:25
 * @Description Country
 * @Version 1.0
 */
@Data
public class Country {
    private Long id;
    private String countryname;
    private String countrycode;
}
