package com.alexcode.vet.core;

import java.util.List;
import java.util.function.Function;

public final class Pagination <T>{
    private final List<T> list;
    private final Integer numberPage;
    private final Integer totalPage;
    private final boolean next;
    private final boolean previous;

    public Pagination(List<T> list, Integer numberPage, Integer totalPage, boolean next, boolean previous) {
        this.list = list;
        this.numberPage = numberPage;
        this.totalPage = totalPage;
        this.next = next;
        this.previous = previous;
    }

    public static <T> Pagination<T> create(List<T> list, Integer numberPage, Integer totalPage, boolean next, boolean previous) {
        return new Pagination<>(list, numberPage, totalPage, next, previous);
    }

    public <U> Pagination<U> map(Function<Pagination<T>, Pagination<U>> mapper) {
        return mapper.apply(this);
    }

    public List<T> getList() {
        return list;
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
}
