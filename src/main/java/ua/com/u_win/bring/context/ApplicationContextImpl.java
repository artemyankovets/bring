package ua.com.u_win.bring.context;

import static java.util.stream.Collectors.toMap;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.reflections.Reflections;
import ua.com.u_win.bring.annotation.Bean;
import ua.com.u_win.bring.exception.BeanException;
import ua.com.u_win.bring.exception.NoSuchBeanException;
import ua.com.u_win.bring.exception.NoUniqueBeanException;

/**
 * Implementation of {@link ApplicationContext}
 *
 * @author Artem Yankovets
 */
public class ApplicationContextImpl implements ApplicationContext {

  private Map<String, Object> beanMap = new HashMap<>();

  public ApplicationContextImpl(String basePackage) {
    var reflections = new Reflections(basePackage);
    var beanClasses = reflections.getTypesAnnotatedWith(Bean.class);
    try {
      createBeans(beanClasses);
    } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
             IllegalAccessException e) {
      throw new BeanException(
          e.getMessage(),
          e,
          this.getClass().getSimpleName(),
          "Exception in bean creating process",
          "Send the message with stacktrace to Bring developer team");
    }
  }

  @Override
  public <T> T getBean(Class<T> type) {
    final Map<String, T> beans = getAllBeans(type);
    if (beans.isEmpty()) {
      throw new NoSuchBeanException(
          this.getClass().getSimpleName(),
          "There is no bean found",
          "The bean should have type: " + type.getSimpleName()
      );
    } else if (beans.size() > 1) {
      throw new NoUniqueBeanException(
          this.getClass().getSimpleName(),
          "There is more then one bean",
          "The name of bean should be unique"
      );
    } else {
      return beans.values().stream().findAny().orElseThrow();
    }
  }

  @Override
  public <T> T getBean(Class<T> type, String name) {
    final Object bean = beanMap.get(name);
    if (bean == null) {
      throw new NoSuchBeanException(
          this.getClass().getSimpleName(),
          "There is no bean found",
          "The bean should have type: " + type.getSimpleName() + " and name: " + name
      );
    }
    return type.cast(bean);
  }

  @Override
  public <T> Map<String, T> getAllBeans(Class<T> type) {
    return beanMap.entrySet()
        .stream()
        .filter(entry -> type.isAssignableFrom(entry.getValue().getClass()))
        .collect(toMap(Map.Entry::getKey, e -> type.cast(e.getValue())));
  }

  private void createBeans(Set<Class<?>> beanClasses)
      throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    for (var beanType : beanClasses) {
      final Constructor<?> constructor = beanType.getConstructor();
      final Object bean = constructor.newInstance();
      final String beanName = resolveBeanName(beanType);
      beanMap.put(beanName, bean);
    }
  }

  private String resolveBeanName(Class<?> beanType) {
    final String explicitName = beanType.getAnnotation(Bean.class).value();
    return explicitName.isEmpty() ? beanType.getSimpleName() : explicitName;
  }

}
