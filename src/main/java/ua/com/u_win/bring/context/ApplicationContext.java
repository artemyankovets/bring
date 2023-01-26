package ua.com.u_win.bring.context;

import java.util.Map;

/**
 * Application context - register of beans.
 * <br>
 * Bean - class registered in context.
 *
 * @author Artem Yankovets
 */
public interface ApplicationContext {

  /**
   * Get bean by type.
   *
   * @param type bean type to get
   * @param <T>  type of the class
   * @return bean
   */
  <T> T getBean(Class<T> type);

  /**
   * Get bean by type and name.
   *
   * @param type bean type to get
   * @param name bean name to get
   * @param <T>  type of the class
   * @return bean
   */
  <T> T getBean(Class<T> type, String name);

  /**
   * Get map of bean names to beans by type.
   *
   * @param type bean type to get
   * @param <T>  type of the class
   * @return map of bean names to beans
   */
  <T> Map<String, T> getAllBeans(Class<T> type);
}
