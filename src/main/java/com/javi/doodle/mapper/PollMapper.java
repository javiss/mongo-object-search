package com.javi.doodle.mapper;

import com.javi.doodle.model.Poll;
import com.javi.doodle.model.PollResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface PollMapper {

    // This is useless on the current implementation, but usually you don't want
    // exactly the same object that is on your DB to be sent to the UI,
    // you might want to remove properties or format it differently and a mapper is useful.
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PollResponse toPoll(Poll dto);
}
