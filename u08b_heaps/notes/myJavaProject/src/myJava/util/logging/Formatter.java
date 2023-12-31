/*
 * @(#)Formatter.java	1.17 05/11/17
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */


package myJava.util.logging;

/**
 * A Formatter provides support for formatting LogRecords.
 * <p>
 * Typically each logging Handler will have a Formatter associated
 * with it.  The Formatter takes a LogRecord and converts it to
 * a string.
 * <p>
 * Some formatters (such as the XMLFormatter) need to wrap head
 * and tail strings around a set of formatted records. The getHeader
 * and getTail methods can be used to obtain these strings.
 *
 * @version 1.17, 11/17/05
 * @since 1.4
 */

public abstract class Formatter {

    /**
     * Construct a new formatter.
     */
    protected Formatter() {
    }

    /**
     * Format the given log record and return the formatted string. 
     * <p>
     * The resulting formatted String will normally include a
     * localized and formated version of the LogRecord's message field.
     * The Formatter.formatMessage convenience method can (optionally)
     * be used to localize and format the message field.
     *
     * @param record the log record to be formatted.
     * @return the formatted log record
     */
    public abstract String format(LogRecord record);


    /**
     * Return the header string for a set of formatted records.
     * <p>  
     * This base class returns an empty string, but this may be
     * overriden by subclasses.
     * 
     * @param   h  The target handler (can be null)
     * @return  header string
     */
    public String getHead(Handler h) {
	return "";
    }

    /**
     * Return the tail string for a set of formatted records.
     * <p>  
     * This base class returns an empty string, but this may be
     * overriden by subclasses.
     * 
     * @param   h  The target handler (can be null)
     * @return  tail string
     */
    public String getTail(Handler h) {
	return "";
    }


    /**
     * Localize and format the message string from a log record.  This
     * method is provided as a convenience for Formatter subclasses to
     * use when they are performing formatting.
     * <p>
     * The message string is first localized to a format string using
     * the record's ResourceBundle.  (If there is no ResourceBundle,
     * or if the message key is not found, then the key is used as the
     * format string.)  The format String uses java.text style
     * formatting.
     * <ul>
     * <li>If there are no parameters, no formatter is used.
     * <li>Otherwise, if the string contains "{0" then
     *     java.text.MessageFormat  is used to format the string.
     * <li>Otherwise no formatting is performed. 
     * </ul> 
     * <p>
     *
     * @param  record  the log record containing the raw message
     * @return   a localized and formatted message
     */
    public synchronized String formatMessage(LogRecord record) {
	String format = record.getMessage();
	java.util.ResourceBundle catalog = record.getResourceBundle();
	if (catalog != null) {
//	    // We cache catalog lookups.  This is mostly to avoid the
//	    // cost of exceptions for keys that are not in the catalog.
//	    if (catalogCache == null) {
//		catalogCache = new HashMap();
//	    }
//	    format = (String)catalogCache.get(record.essage);
//	    if (format == null) {
	        try {
	            format = catalog.getString(record.getMessage());
	        } catch (java.util.MissingResourceException ex) {
		    // Drop through.  Use record message as format
		    format = record.getMessage();
		}
//		catalogCache.put(record.message, format);
//	    }
	}
  	// Do the formatting.
	try {
	    Object parameters[] = record.getParameters();
 	    if (parameters == null || parameters.length == 0) {
		// No parameters.  Just return format string.
		return format;
	    }
	    // Is is a java.text style format?
            // Ideally we could match with
            // Pattern.compile("\\{\\d").matcher(format).find())
            // However the cost is 14% higher, so we cheaply check for
            // 1 of the first 4 parameters
            if (format.indexOf("{0") >= 0 || format.indexOf("{1") >=0 ||
                        format.indexOf("{2") >=0|| format.indexOf("{3") >=0) {
	        return java.text.MessageFormat.format(format, parameters);
	    }
	    return format;

	} catch (Exception ex) {
	    // Formatting failed: use localized format string.
	    return format;
	}
    }
}



