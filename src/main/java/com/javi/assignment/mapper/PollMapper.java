package com.javi.assignment.mapper;

import com.javi.assignment.model.Poll;
import com.javi.assignment.model.PollResponse;
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
