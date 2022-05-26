package com.alexcode.vet.web.response;

import java.io.Serializable;

public class SingleResponse <T extends Serializable> implements Serializable {
    private final T data;
    private final boolean success;

    public SingleResponse(T data) {
        this.data = data;
        this.success = true;
    }

    public static <T extends Serializable> SingleResponse<T> create(T data) {
        return new SingleResponse<>(data);
    }

    public T getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }
}
