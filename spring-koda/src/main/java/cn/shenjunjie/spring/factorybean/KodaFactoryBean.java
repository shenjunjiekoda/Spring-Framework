package cn.shenjunjie.spring.factorybean;

import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.dao.support.DaoSupport;
import org.springframework.util.Assert;


/**
 * @author Junjie.Shen
 * @version 1.0
 * @date 2020/4/4 10:53
 */
public class KodaFactoryBean extends DaoSupport implements FactoryBean<Object>  {

	private Class<?> mapperInterface;

	private SqlSessionTemplate sqlSessionTemplate;

	//需要自动装配进来
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		if (this.sqlSessionTemplate == null || sqlSessionFactory != this.sqlSessionTemplate.getSqlSessionFactory()) {
			this.sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
		}
	}

	public KodaFactoryBean(Class<?> mapperInterface){
		this.mapperInterface = mapperInterface;
	}

	@Override
	public Object getObject() throws Exception {
		return sqlSessionTemplate.getMapper(this.mapperInterface);
	}

	@Override
	public Class<?> getObjectType() {
		return mapperInterface;
	}

	@Override
	protected void checkDaoConfig() throws IllegalArgumentException {
		//往Mybatis的关键Configuration添加xxxMapper.class
		Configuration configuration = this.sqlSessionTemplate.getConfiguration();
		if (!configuration.hasMapper(this.mapperInterface)) {
			try {
				configuration.addMapper(this.mapperInterface);
			} catch (Exception e) {
				throw new IllegalArgumentException(e);
			} finally {
				ErrorContext.instance().reset();
			}
		}
	}
}
