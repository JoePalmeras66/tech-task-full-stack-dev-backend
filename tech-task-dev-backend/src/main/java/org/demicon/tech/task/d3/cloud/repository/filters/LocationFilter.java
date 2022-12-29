package org.demicon.tech.task.d3.cloud.repository.filters;

import com.google.common.base.Strings;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.demicon.tech.task.d3.cloud.repository.filters.utils.BaseFilter;

import static org.demicon.tech.task.d3.cloud.repository.LocationRepository.qLocation;

public class LocationFilter {

    public static BooleanBuilder filter(String country,
                                        String state,
                                        String city) {
        Predicate predicateCountry = Strings.isNullOrEmpty(country) ? null : qLocation.country.toLowerCase().eq(country.toLowerCase());
        Predicate predicateState = Strings.isNullOrEmpty(state) ? null : qLocation.state.toLowerCase().eq(state.toLowerCase());
        Predicate predicateCity = Strings.isNullOrEmpty(city) ? null : qLocation.city.toLowerCase().eq(city.toLowerCase());

        BooleanBuilder predicateBuilder = (Strings.isNullOrEmpty(country)) ? new BooleanBuilder()
                : BaseFilter.filterBasePredicate(country, new BooleanBuilder(), predicateCountry);
        predicateBuilder = (Strings.isNullOrEmpty(state)) ? predicateBuilder
                : BaseFilter.filterBasePredicate(state, predicateBuilder, predicateState);
        predicateBuilder = (Strings.isNullOrEmpty(city)) ? predicateBuilder
                : BaseFilter.filterBasePredicate(city, predicateBuilder, predicateCity);
        return predicateBuilder;
    }
}