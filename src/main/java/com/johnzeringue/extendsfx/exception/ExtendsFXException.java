/*
 * Copyright 2015 John Zeringue.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.johnzeringue.extendsfx.exception;

/**
 * An unchecked {@link Exception} originating from ExtendsFX.
 * <p>
 * Constructors are not provided matching {@link Exception#Exception()} or
 * {@link Exception#Exception(java.lang.Throwable)}, because every exception
 * originating from ExtendsFX should have a specific message explaining its
 * cause.
 *
 * @author John Zeringue
 */
public class ExtendsFXException extends RuntimeException {

    /**
     * Creates a new exception with the given message, like
     * {@link Exception#Exception(java.lang.String)}.
     *
     * @param message the detail message
     */
    public ExtendsFXException(String message) {
        super(message);
    }

    /**
     * Creates a new exception with the given message and cause, like
     * {@link Exception#Exception(java.lang.String, java.lang.Throwable)}.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public ExtendsFXException(String message, Throwable cause) {
        super(message, cause);
    }

}
