package org.demicon.tech.task.d3.cloud.converter.toresponse.page;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public record SortBy(
        List<SortFilter> filters
) {

    public static final SortBy NONE = new SortBy(Collections.emptyList());

    public SortBy(final List<SortFilter> filters) {
        this.filters = Optional.ofNullable(filters).orElse(Collections.emptyList());
    }

    public static Builder builder() {
        return new Builder();
    }

    public SortBy and(final SortBy sortBy) {
        final ArrayList<SortFilter> concatenatedFilters = new ArrayList<>(filters);
        concatenatedFilters.addAll(sortBy.filters());
        return new SortBy(concatenatedFilters);
    }

    @Override
    public List<SortFilter> filters() {
        return new ArrayList<>(filters);
    }

    public static enum Order {
        ASCENDING,
        DESCENDING;

        public static Order of(final String s) {
            return switch (s.trim().toLowerCase()) {
                case "a", "asc", "ascending" -> ASCENDING;
                case "d", "dsc", "desc", "descending" -> DESCENDING;
                default -> null;
            };
        }
    }

    public static final class Builder {

        List<SortFilter> filters = new ArrayList<>();

        public Builder addFilter(final SortFilter filter) {
            filters.add(filter);
            return this;
        }

        public Builder addFilters(final Collection<SortFilter> filters) {
            this.filters.addAll(filters);
            return this;
        }

        public SortBy build() {
            return new SortBy(filters);
        }
    }

    public static record SortFilter(
            String field,
            Order order
    ) {

        public SortFilter(final String field) {
            this(field, null);
        }

        public SortFilter(final String field, final Order order) {
            this.field = field;
            this.order = Optional.ofNullable(order).orElse(Order.ASCENDING);
        }
    }
}
