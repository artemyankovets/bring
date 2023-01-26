package ua.com.u_win.bring.exception;

import java.io.Serial;

/**
 * Exception throws when nothing is found
 *
 * @author Artem Yankovets
 */
public class NoSuchBeanException extends BeanException {

  @Serial
  private static final long serialVersionUID = -1779328194869358622L;

  public NoSuchBeanException(String location, String exceptionCause, String suggestedSolution) {
    super(location, exceptionCause, suggestedSolution);
  }

}
