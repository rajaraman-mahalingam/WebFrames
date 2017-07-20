package com.steeleye.iris.automation.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TestRunManager {
  public static <T extends Annotation> T getTestAnnotation(Class<T> annotationClass) {
    Class<?> clazz;
    Method method;
    try {
      clazz = (Config.getTestClass() == null) ? null : Class.forName(Config.getTestClass());
      method = (Config.getTestName() == null) ? null : clazz.getMethod(Config.getTestName());
    } catch (ClassNotFoundException | NoSuchMethodException | SecurityException e) {
      return null;
    }
    if ((method == null) || !method.isAnnotationPresent(annotationClass)) {
      return null;
    }
    return method.getAnnotation(annotationClass);
  }
  
  public static String getTestDescription() throws ClassNotFoundException, NoSuchMethodException {
    try {
      if (getTestAnnotation(TestDescription.class) == null) {
        return "";
      }
      TestDescription testDescription = getTestAnnotation(TestDescription.class);
      return testDescription.value();
    } catch (NullPointerException e) {
      return "";
    }
  }
}
