package com.alexcode.vet.web.response;

import java.io.Serializable;
import java.util.List;

public class ListResponse <T extends Serializable> implements Serializable {
    private final List<T> data;
    private final Integer numberPage;
    private final Integer totalPage;
    private final boolean next;
    private final boolean previous;
    private final boolean success;

    public ListResponse(List<T> data, Integer numberPage, Integer totalPage, boolean next, boolean previous) {
        this.data = data;
        this.numberPage = numberPage;
        this.totalPage = totalPage;
        this.next = next;
        this.previous = previous;
        this.success = true;
    }

    public static <T extends Serializable> ListResponse<T> create(List<T> data, Integer numberPage, Integer totalPage, boolean next, boolean previous) {
        return new ListResponse<>(data, numberPage, totalPage, next, previous);
    }

    public List<T> getData() {
        return data;
    }

    public Integer getNumberPage() {
        return numberPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public boolean isNext() {
        return next;
    }

    public boolean isPrevious() {
        return previous;
    }

    public boolean isSuccess() {
        return success;
    }
}
