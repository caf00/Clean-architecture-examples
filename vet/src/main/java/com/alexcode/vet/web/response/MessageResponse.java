package com.alexcode.vet.web.response;

import java.io.Serializable;

public class MessageResponse implements Serializable {
    private final String message;
    private final boolean success;

    public MessageResponse(String message) {
        this.message = message;
        this.success = true;
    }

    public static MessageResponse newResponse(String message) {
        return new MessageResponse(message);
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }
}
