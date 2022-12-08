package org.demicon.tech.task.d3.cloud.converter.tomodels;

import org.demicon.tech.task.d3.cloud.entity.Timezone;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TimezoneEntityToModelConverter implements Converter<Timezone, org.demicon.tech.task.d3.cloud.domain.model.Timezone> {
    @Override
    public org.demicon.tech.task.d3.cloud.domain.model.Timezone convert(Timezone source) {
        org.demicon.tech.task.d3.cloud.domain.model.Timezone timezone = new org.demicon.tech.task.d3.cloud.domain.model.Timezone();
        timezone.setOffset(source.getTimezone_offset());
        timezone.setDescription(source.getDescription());
        return timezone;
    }
}
