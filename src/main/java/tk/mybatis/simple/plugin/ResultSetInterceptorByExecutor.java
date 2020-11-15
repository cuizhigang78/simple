package tk.mybatis.simple.plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.RowBounds;

import java.sql.Statement;
import java.util.Properties;

/**
 * @ClassName ResultSetInterceptor
 * @Author Maxwell
 * @Date 2020/11/14 22:15
 * @Description ResultSetInterceptor ParameterHandler
 * @Version 1.0
 */
@Intercepts({
        @Signature(
                type = Executor.class,
                method = "commit",
                args = {boolean.class}
        )
})
public class ResultSetInterceptorByExecutor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return null;
    }

    @Override
    public Object plugin(Object target) {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
