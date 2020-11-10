package com.javi.assignment.rest;

import com.javi.assignment.api.PollsApi;
import com.javi.assignment.exception.NotSupportedException;
import com.javi.assignment.model.PollResponse;
import com.javi.assignment.service.PollsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@Slf4j
@AllArgsConstructor
public class PollsController implements PollsApi {

    final PollsService pollsService;

    @Override
    public Flux<PollResponse> pollsSearch(@Valid String text, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Valid LocalDate fromdate, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Valid LocalDate untildate) {

        log.debug("Searching for polls");

        try {
            return pollsService.search(text, fromdate, untildate);

        } catch (NotSupportedException e) {
            return null;
        }

    }
}


