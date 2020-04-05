package cn.shenjunjie.spring.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author Junjie.Shen
 * @version 1.0
 * @date 2020/4/4 10:55
 */
public interface KodaMapper {

	@Select("select * from test_user")
	List<Map<String,Object>> query();

}
