package com.steeleye.iris.automation.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TestRunManager {

	public static <T extends Annotation> T getTestAnnotation(Class<T> annotationClass)
	    throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		Class<?> clazz;
		Method method;
		try {
			clazz = (Config.getTestClass() == null) ? null : Class.forName(Config.getTestClass());
			method = (Config.getTestName() == null) ? null : clazz.getMethod(Config.getTestName());
		} catch (Exception e) {
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

	public static String getTestRunConditon() throws ClassNotFoundException, NoSuchMethodException {
		try {
			if (getTestAnnotation(RunConditions.class) == null) {
				return "";
			}
			RunConditions runCondition = getTestAnnotation(RunConditions.class);
			return runCondition.value();
		} catch (NullPointerException e) {
			return "";
		}
	}
	
	public static String getTestPriority() throws ClassNotFoundException, NoSuchMethodException {
		try {
			if (getTestAnnotation(Priorities.class) == null) {
				return "";
			}
			Priorities priority = getTestAnnotation(Priorities.class);
			return priority.value();
		} catch (NullPointerException e) {
			return "";
		}
	}
}
