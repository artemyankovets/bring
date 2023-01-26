package ua.com.u_win.bring.exception;

import java.io.Serial;

/**
 * Exception throws when more than one bean is found
 *
 * @author Artem Yankovets
 */
public class NoUniqueBeanException extends BeanException {

  @Serial
  private static final long serialVersionUID = 8029841796844048114L;

  public NoUniqueBeanException(String location, String exceptionCause, String suggestedSolution) {
    super(location, exceptionCause, suggestedSolution);
  }

}
