package tk.mybatis.simple.plugin;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.session.RowBounds;

/**
 * @ClassName PageRowBounds
 * @Author Maxwell
 * @Date 2020/11/15 20:57
 * @Description PageRowBounds
 * @Version 1.0
 */
@NoArgsConstructor
@Data
public class PageRowBounds extends RowBounds {

    private long total;

    public PageRowBounds(int offset, int limit) {
        super(offset, limit);
    }
}
