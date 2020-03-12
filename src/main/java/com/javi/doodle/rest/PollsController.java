package com.javi.doodle.rest;

import com.javi.doodle.api.PollsApi;
import com.javi.doodle.exception.NotSupportedException;
import com.javi.doodle.model.PollResponse;
import com.javi.doodle.service.PollsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@Slf4j
@AllArgsConstructor
public class PollsController implements PollsApi {

    final PollsService pollsService;

    @Override
    public ResponseEntity<List<PollResponse>> pollsSearch(@Valid String text, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Valid LocalDate fromdate, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Valid LocalDate untildate) {

        log.debug("Searching for polls");

        try {
            return ResponseEntity.ok(pollsService.search(text, fromdate, untildate));

        } catch (NotSupportedException e) {
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }

    }
}


