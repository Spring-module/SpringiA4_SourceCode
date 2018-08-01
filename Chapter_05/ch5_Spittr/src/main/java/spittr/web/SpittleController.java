package spittr.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.Spittle;
import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

  private static final String MAX_LONG_AS_STRING = "9223372036854775807";
  
  private SpittleRepository spittleRepository;

  @Autowired
  public SpittleController(SpittleRepository spittleRepository) {
	  // 使用@Autowired注解，注入SpittleRepository
    this.spittleRepository = spittleRepository;
  }

  /**
   * spittles:展现最新的Spittle列表（包括分页）. <br/>
   *
   * @param max
   * 	返回的Spittle中，Spittle ID属性的最大值
   * @param count
   * 	表明要返回多少个Spittle对象
   * @return
   */
  @RequestMapping(method=RequestMethod.GET)
  public List<Spittle> spittles(
      @RequestParam(value="max", defaultValue=MAX_LONG_AS_STRING) long max,
      @RequestParam(value="count", defaultValue="20") int count) {
	  //它并没有返回视图名称，也没有显式地设定模型，这个方法返回的是Spittle列表。
	  //当处理器方法像这样返回对象或集合时，这个值会放到模型中，模型的key会根据其类型推断得出（在本例中，也就是spittleList）
    return spittleRepository.findSpittles(max, count);
  }

  /**
   * spittle:根据给定的ID来展现某一个Spittle记录. <br/>
   *
   * @param spittleId
   * @param model
   * @return
   */
  @RequestMapping(value="/{spittleId}", method=RequestMethod.GET)
  public String spittle(
      @PathVariable("spittleId") long spittleId, 
      Model model) {
    model.addAttribute(spittleRepository.findOne(spittleId));
    return "spittle";
  }

  /**
   * saveSpittle:添加一条Spittle记录. <br/>
   *
   * @param form
   * @param model
   * @return
   * @throws Exception
   */
  @RequestMapping(method=RequestMethod.POST)
  public String saveSpittle(SpittleForm form, Model model) throws Exception {
    spittleRepository.save(new Spittle(null, form.getMessage(), new Date(), 
        form.getLongitude(), form.getLatitude()));
    return "redirect:/spittles";
  }

}
