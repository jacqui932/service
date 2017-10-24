package com.rhindon.bridge.exception

class ChargeException extends RuntimeException {

    ChargeException(String message) {
        super(message)
    }

    ChargeException(String message, Exception e) {
        super(message, e)
    }
}
