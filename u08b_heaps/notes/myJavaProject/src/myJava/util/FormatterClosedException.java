/*
 * @(#)FormatterClosedException.java	1.3 05/11/17
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package myJava.util;

/**
 * Unchecked exception thrown when the formatter has been closed.
 *
 * <p> Unless otherwise specified, passing a <tt>null</tt> argument to any
 * method or constructor in this class will cause a {@link
 * NullPointerException} to be thrown.
 *
 * @version 	1.3, 11/17/05
 * @since 1.5
 */
public class FormatterClosedException extends IllegalStateException {

    private static final long serialVersionUID = 18111216L;
    
    /**
     * Constructs an instance of this class.
     */
    public FormatterClosedException() { }
}
