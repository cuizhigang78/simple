package tk.mybatis.simple.plugin;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * @ClassName ResultSetInterceptor
 * @Author Maxwell
 * @Date 2020/11/14 22:15
 * @Description ResultSetInterceptor ResultSetHandler
 * @Version 1.0
 */
@Intercepts({
        @Signature(
                type = ParameterHandler.class,
                method = "setParameters",
                args = {PreparedStatement.class}
        )
})
public class ResultSetInterceptorByParameterHandler implements Interceptor {
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
