package tk.mybatis.simple.plugin;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.sql.CallableStatement;
import java.util.Properties;

/**
 * @ClassName ResultSetInterceptor
 * @Author Maxwell
 * @Date 2020/11/14 22:15
 * @Description ResultSetInterceptor StatementHandler
 * @Version 1.0
 */
@Intercepts({
        @Signature(
                type = ResultSetHandler.class,
                method = "handleOutputParameters",
                args = {CallableStatement.class}
        )
})
public class ResultSetInterceptorByResultSetHandler implements Interceptor {
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
