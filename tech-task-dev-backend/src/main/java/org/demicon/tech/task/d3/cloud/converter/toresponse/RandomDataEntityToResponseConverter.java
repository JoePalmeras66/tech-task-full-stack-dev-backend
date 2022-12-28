package org.demicon.tech.task.d3.cloud.converter.toresponse;

import org.demicon.tech.task.d3.cloud.entity.RandomUser;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tech.task.d3.cloud.api.model.RandomUserDTO;

@Component
public class RandomDataEntityToResponseConverter implements Converter<RandomUser, RandomUserDTO> {
    @Override
    public RandomUserDTO convert(RandomUser source) {
        RandomUserDTO randomUserDTO = new RandomUserDTO();
        randomUserDTO.setFirst(source.getName().getFirst());
        randomUserDTO.setLast(source.getName().getLast());
        randomUserDTO.setGender(source.getGender());
        randomUserDTO.setEmail(source.getEmail());
        randomUserDTO.setCountry(source.getLocation().getCountry());
        randomUserDTO.setCity(source.getLocation().getCity());
        randomUserDTO.setState(source.getLocation().getState());
        return randomUserDTO;
    }
}