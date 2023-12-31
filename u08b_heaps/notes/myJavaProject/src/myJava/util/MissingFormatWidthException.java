/*
 * @(#)MissingFormatWidthException.java	1.3 05/11/17
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package myJava.util;

/**
 * Unchecked exception thrown when the format width is required.
 *
 * <p> Unless otherwise specified, passing a <tt>null</tt> argument to anyg
 * method or constructor in this class will cause a {@link
 * NullPointerException} to be thrown.
 *
 * @version 	1.3, 11/17/05
 * @since 1.5
 */
public class MissingFormatWidthException extends IllegalFormatException {

    private static final long serialVersionUID = 15560123L;

    private String s;

    /**
     * Constructs an instance of this class with the specified format
     * specifier. 
     *
     * @param  s
     *         The format specifier which does not have a width
     */
    public MissingFormatWidthException(String s) {
	if (s == null)
	    throw new NullPointerException();
	this.s = s;
    }

    /**
     * Returns the format specifier which does not have a width.
     *
     * @return  The format specifier which does not have a width
     */
    public String getFormatSpecifier() {
	return s;
    }

    public String getMessage() {
	return s;
    }
}
