package com.asyncapi.bindings.http.v0._2_0.operation;

/**
 * Describes HTTP operation method.
 * <p>
 * Contains information about the operation method.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/http#operation-binding-object">HTTP operation binding</a>
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Overview">MDN HTTP overview</a>
 * @author Pavel Bodiachevskii
 * @version 0.2.0
 * @since 1.0.0-RC2
 */
public enum HTTPOperationMethod {
    GET,
    PUT,
    POST,
    PATCH,
    DELETE,
    HEAD,
    OPTIONS,
    CONNECT,
    TRACE
}
