package ua.com.u_win.bring.exception;

/**
 * General class to handle exceptions in general way
 *
 * @author Artem Yankovets
 */
public class BeanException extends RuntimeException {

  private final String location;
  private final String exceptionCause;
  private final String suggestedSolution;

  public BeanException(String location, String exceptionCause, String suggestedSolution) {
    this.location = location;
    this.exceptionCause = exceptionCause;
    this.suggestedSolution = suggestedSolution;
  }

  public BeanException(String message, Throwable cause, String location, String exceptionCause,
      String suggestedSolution) {
    super(message, cause);
    this.location = location;
    this.exceptionCause = exceptionCause;
    this.suggestedSolution = suggestedSolution;
  }

  public String getLocation() {
    return location;
  }

  public String getExceptionCause() {
    return exceptionCause;
  }

  public String getSuggestedSolution() {
    return suggestedSolution;
  }
}
