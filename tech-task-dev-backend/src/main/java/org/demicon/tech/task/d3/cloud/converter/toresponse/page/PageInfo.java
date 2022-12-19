package org.demicon.tech.task.d3.cloud.converter.toresponse.page;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface PageInfo<E> {

    static <E> Builder<E> builder() {
        return new Builder<>();
    }

    int number();

    int pageSize();

    long totalElements();

    List<E> contents();

    static

    final class Builder<E> {

        int number = 1;
        int pageSize = 20;
        long totalElements;
        List<E> contents;

        private Builder() {
            contents = Collections.emptyList();
        }

        public Builder<E> number(final int number) {
            this.number = number;
            return this;
        }

        public Builder<E> pageSize(final int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder<E> totalElements(final long totalElements) {
            this.totalElements = totalElements;
            return this;
        }

        public Builder<E> contents(final List<E> contents) {
            this.contents = Optional.of(contents).orElse(Collections.emptyList());
            return this;
        }

        public PageInfo<E> build() {
            return new PageInfoRecord<>(
                    number,
                    pageSize,
                    totalElements,
                    contents
            );
        }
    }
}

record PageInfoRecord<E>(int number, int pageSize, long totalElements, List<E> contents) implements
        PageInfo<E> {

    PageInfoRecord(final int number, final int pageSize, final long totalElements,
                   final List<E> contents) {
        this.number = number;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        this.contents = new ArrayList<>(Optional.ofNullable(contents).orElse(Collections.emptyList()));
    }

    @Override
    public List<E> contents() {
        return new ArrayList<>(contents);
    }
}

