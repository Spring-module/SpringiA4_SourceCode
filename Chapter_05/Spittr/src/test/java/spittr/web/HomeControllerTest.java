package spittr.web;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import spittr.web.HomeController;

public class HomeControllerTest {

  @Test
  public void testHomePage() throws Exception {
    HomeController controller = new HomeController();
    // 搭建 MockMvc
    MockMvc mockMvc = standaloneSetup(controller).build();
    // 对"/"执行GET请求，并预期得到home视图
    mockMvc.perform(get("/"))
           .andExpect(view().name("home"));
  }

}
