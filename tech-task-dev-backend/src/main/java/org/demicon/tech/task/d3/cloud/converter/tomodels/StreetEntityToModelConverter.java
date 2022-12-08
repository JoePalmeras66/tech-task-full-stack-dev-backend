package org.demicon.tech.task.d3.cloud.converter.tomodels;

import org.demicon.tech.task.d3.cloud.entity.Street;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StreetEntityToModelConverter implements Converter<Street, org.demicon.tech.task.d3.cloud.domain.model.Street> {
    @Override
    public org.demicon.tech.task.d3.cloud.domain.model.Street convert(Street source) {
        org.demicon.tech.task.d3.cloud.domain.model.Street street = new org.demicon.tech.task.d3.cloud.domain.model.Street();
        street.setName(source.getName());
        street.setNumber(String.valueOf(source.getNumber()));
        return street;
    }
}
