package com.veterinaria.veterinaria.veterinarios.common.veterinaria;

public class InvalidVeterinariaException extends Exception {

  private static final long serialVersionUID = -8890080495441147845L;

  private String message;
  private Object[] args;

  public InvalidVeterinariaException(String arg) {

    this.message = String.format("%s is an invalid veterinary or exist.", arg);
  }

  public InvalidVeterinariaException(Object[] args) {

    this.args = args;
  }

  public InvalidVeterinariaException(String message, Object[] args) {
    this.message = message;
    this.args = args;
  }

  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * @return the args
   */
  public Object[] getArgs() {
    return args;
  }

  /**
   * @param args the args to set
   */
  public void setArgs(Object[] args) {
    this.args = args;
  }
}