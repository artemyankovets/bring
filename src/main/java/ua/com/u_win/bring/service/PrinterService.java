package ua.com.u_win.bring.service;

import ua.com.u_win.bring.annotation.Bean;

/**
 * Service to print messages
 *
 * @author Artem Yankovets
 */
@Bean("printerService")
public class PrinterService {

  /**
   * Print message
   */
  public void printMessage() {
    System.out.println("Hello from PrinterService. " + this.getClass().getSimpleName());
  }

}
