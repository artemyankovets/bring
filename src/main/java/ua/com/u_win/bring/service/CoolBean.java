package ua.com.u_win.bring.service;

import ua.com.u_win.bring.annotation.Bean;

/**
 * @author Artem Yankovets
 */
@Bean
public class CoolBean {

  public void doSomethingCool() {
    System.out.println("This is a very cool... bean. " + this.getClass().getSimpleName());
  }

}
