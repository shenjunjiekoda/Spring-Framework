package cn.shenjunjie.spring.config;

import cn.shenjunjie.spring.annotations.KodaScan;
import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.logging.Log4j2Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.cj.jdbc.Driver;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Junjie.Shen
 * @version 1.0
 * @date 2020/4/4 20:01
 */
@Configuration
@KodaScan("cn.shenjunjie.spring.dao")
public class MyBatisConfig {

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		return factoryBean.getObject();
	}

	@Bean
	public DataSourceTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	public DataSource dataSource() throws SQLException {
		//druid数据源
		DruidDataSource dataSource = new DruidDataSource();
		//
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(Driver.class.getName());
		dataSource.setUrl("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf8");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		//初始大小，最小空闲，最大活跃
		dataSource.setInitialSize(10);
		dataSource.setMinIdle(10);
		dataSource.setMaxActive(50);
		//获取连接超时时间
		dataSource.setMaxWait(10000);
		//配置log4j2日志输出
		List<Filter> filters = new ArrayList<>();
		Log4j2Filter filter = new Log4j2Filter();
		filters.add(filter);
		dataSource.setProxyFilters(filters);
		return dataSource;
	}

}
