/*
 * @(#)RejectedExecutionException.java	1.5 05/11/17
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package myJava.util.concurrent;

/**
 * Exception thrown by an {@link Executor} when a task cannot be
 * accepted for execution.
 *
 * @since 1.5
 * @author Doug Lea
 */
public class RejectedExecutionException extends RuntimeException {
    private static final long serialVersionUID = -375805702767069545L;

    /**
     * Constructs a <tt>RejectedExecutionException</tt> with no detail message.
     * The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause(Throwable) initCause}.
     */
    public RejectedExecutionException() { }

    /**
     * Constructs a <tt>RejectedExecutionException</tt> with the
     * specified detail message. The cause is not initialized, and may
     * subsequently be initialized by a call to {@link
     * #initCause(Throwable) initCause}.
     *
     * @param message the detail message
     */
    public RejectedExecutionException(String message) {
        super(message);
    }

    /**
     * Constructs a <tt>RejectedExecutionException</tt> with the
     * specified detail message and cause.
     *
     * @param  message the detail message
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method)
     */
    public RejectedExecutionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a <tt>RejectedExecutionException</tt> with the
     * specified cause.  The detail message is set to: <pre> (cause ==
     * null ? null : cause.toString())</pre> (which typically contains
     * the class and detail message of <tt>cause</tt>).
     *
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method)
     */
    public RejectedExecutionException(Throwable cause) {
        super(cause);
    }
}
