package com.javi.doodle.service;

import com.javi.doodle.exception.NotSupportedException;
import com.javi.doodle.mapper.PollMapper;
import com.javi.doodle.model.Poll;
import com.javi.doodle.model.PollResponse;
import com.javi.doodle.repository.PollRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class PollsService {

    final PollRepository repository;
    final PollMapper mapper;

    public List<PollResponse> search(String text, LocalDate fromDate, LocalDate untilDate) throws NotSupportedException {

        // text search while specifying range is not supported
        if (text != null && (fromDate != null || untilDate != null))
            throw new NotSupportedException();

        List<Poll> result = new ArrayList<>();

        // search by text
        if (text != null)
            result = repository.findByTitleContains(text);

            // search in range
        else if (fromDate != null && untilDate != null)
            result = repository.findByDateRange(fromDate, untilDate);

            // search from start date
        else if (fromDate != null)
            result = repository.findFromDate(fromDate);

            //search from end date
        else if (untilDate != null)
            result = repository.findUntilDate(untilDate);

        if (result.isEmpty())
            log.debug("No polls found");

        return result.stream().map(mapper::toPoll).collect(Collectors.toList());
    }

}
