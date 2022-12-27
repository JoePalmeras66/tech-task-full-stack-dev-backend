package org.demicon.tech.task.d3.cloud.repository.filters;

import com.google.common.base.Strings;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static org.demicon.tech.task.d3.cloud.repository.LocationRepository.qLocation;

@Component
public class LocationFilterImpl {

    public static BooleanBuilder filter(String country,
                                        String state,
                                        String city) {
        BooleanBuilder predicateBuilder = (Strings.isNullOrEmpty(country)) ? new BooleanBuilder()
                : filterCountryPredicate(country, new BooleanBuilder());
        predicateBuilder = (Strings.isNullOrEmpty(state)) ? predicateBuilder
                : filterStatePredicate(state, predicateBuilder);
        predicateBuilder = (Strings.isNullOrEmpty(city)) ? predicateBuilder
                : filterCityPredicate(city, predicateBuilder);
        return predicateBuilder;
    }

    public static BooleanBuilder filterPredicate(String filterValue,
                                                 Predicate predicate,
                                                 BooleanBuilder predicateBuilder) {
        if(Objects.isNull(predicate) || Strings.isNullOrEmpty(filterValue))
            return predicateBuilder;

        if(Objects.isNull(predicateBuilder) && Objects.nonNull(predicate))
            return new BooleanBuilder(predicate);

        return predicateBuilder.and(predicate);
    }

    public static BooleanBuilder filterCountryPredicate(String country,
                                                        BooleanBuilder predicateBuilder) {
        Predicate predicateCountry = qLocation.country.toLowerCase().eq(country.toLowerCase());
        return filterPredicate(country, predicateCountry, predicateBuilder);
    }

    public static BooleanBuilder filterStatePredicate(String state,
                                                      BooleanBuilder predicateBuilder) {
        Predicate predicateState = qLocation.state.toLowerCase().eq(state.toLowerCase());
        return filterPredicate(state, predicateState, predicateBuilder);
    }

    public static BooleanBuilder filterCityPredicate(String city,
                                                     BooleanBuilder predicateBuilder) {
        Predicate predicateCity = qLocation.city.toLowerCase().eq(city.toLowerCase());
        return filterPredicate(city, predicateCity, predicateBuilder);
    }
}