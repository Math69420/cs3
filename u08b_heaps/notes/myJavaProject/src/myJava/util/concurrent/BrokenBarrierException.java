/*
 * @(#)BrokenBarrierException.java	1.4 05/11/17
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package myJava.util.concurrent;

/**
 * Exception thrown when a thread tries to wait upon a barrier that is
 * in a broken state, or which enters the broken state while the thread
 * is waiting.
 *
 * @see CyclicBarrier
 *
 * @since 1.5
 * @author Doug Lea
 *
 */
public class BrokenBarrierException extends Exception {
    private static final long serialVersionUID = 7117394618823254244L;

    /**
     * Constructs a <tt>BrokenBarrierException</tt> with no specified detail
     * message.
     */
    public BrokenBarrierException() {}

    /**
     * Constructs a <tt>BrokenBarrierException</tt> with the specified
     * detail message.
     *
     * @param message the detail message
     */
    public BrokenBarrierException(String message) {
        super(message);
    }
}
