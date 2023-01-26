package ua.com.u_win.bring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.u_win.bring.context.ApplicationContextImpl;
import ua.com.u_win.bring.service.CoolBean;
import ua.com.u_win.bring.service.PrinterService;

/**
 * Bring Application class
 *
 * @author Artem Yankovets
 */
public class BringApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(BringApplication.class);

  /**
   * Bring project entry point
   *
   * @param args array of arguments
   */
  public static void main(String[] args) {
    LOGGER.info("Hello, from Bring team!");

    var context = new ApplicationContextImpl("ua.com.u_win.bring");
    var coolBean = context.getBean(CoolBean.class);
    coolBean.doSomethingCool();
    var printerService = context.getBean(PrinterService.class, "printerService");
    printerService.printMessage();
  }
}
