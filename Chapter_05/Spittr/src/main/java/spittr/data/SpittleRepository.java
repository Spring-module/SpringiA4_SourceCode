package spittr.data;

import java.util.List;

import spittr.Spittle;

/**
 * ClassName: SpittleRepository（接口） <br/>
 * Function: 定义一个数据访问的Reponsitory. <br/>
 * Date: 2017年2月15日 下午3:28:30 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public interface SpittleRepository {

  List<Spittle> findRecentSpittles();

  /**
   * findSpittles:获取Spittle列表. <br/>
   *
   * @param max
   * 	返回的Spittle中，Spittle ID属性的最大值
   * @param count
   * 	表明要返回多少个Spittle对象
   * @return
   */
  List<Spittle> findSpittles(long max, int count);
  
  Spittle findOne(long id);

  void save(Spittle spittle);

}
