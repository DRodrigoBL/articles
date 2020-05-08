package com.hackerrank.articles.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Class with methods to help print in log.
 */
public class LoggingUtils {

  /**
   * Logger instance for LoggingUtils.
   */
  private static final Logger LOG = LoggerFactory.getLogger(LoggingUtils.class);
  private static final ObjectMapper mapper = new ObjectMapper();

  /**
   * Minimal constructor.
   */
  private LoggingUtils() {}

  /**
   * Method to convert a object to JSON format to print in log.
   * 
   * @param object - object to be formatted.
   * @param beautified - indicates if pretty print enabled.
   * @return String in JSON format
   */
  public static <T> String getJsonFormat(T object, boolean beautified) {
    String result = null;
    try {
      if (beautified) {
        result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
      } else {
        result = mapper.writeValueAsString(object);
      }
    } catch (JsonProcessingException jpe) {
      LOG.error(jpe.getMessage(), jpe);
    }
    return result;
  }

  /**
   * Method to extract and format the stackTrace from an exception.
   * 
   * @param thr exception to process
   * @return a string formatted with the stack trace
   */
  public static String getStackTrace(Throwable thr) {
    String result = null;
    if (thr != null) {
      StringWriter sw = new StringWriter();
      thr.printStackTrace(new PrintWriter(sw));
      result = sw.toString();
    }
    return result;
  }
  
}
