package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import spittr.web.WebConfig;

public class SpitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  
  /**
   * 用来配置ContextLoaderListener创建的应用上下文中的Bean
   */
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class<?>[] { RootConfig.class };
  }

  /**
   * 用来定义DispatcherServlet应用上下文中的Bean
   * 要求DispatcherServlet加载应用上下文时，使用定义在WebConfig配置类中的Bean。
   */
  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] { WebConfig.class };
  }

  /**
   * 将一个或多个路径映射到DispatcherServlet上。
   * "/"：这表示它会是应用的默认Servlet，它会处理进入应用的所有请求。
   */
  @Override
  protected String[] getServletMappings() {
    return new String[] { "/" };
  }

}