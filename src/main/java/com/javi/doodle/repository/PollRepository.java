package com.javi.doodle.repository;

import com.google.common.base.Preconditions;
import com.javi.doodle.model.Poll;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;

@AllArgsConstructor
@Service
public class PollRepository {

    private CustomPollRepository repository;

    public List<Poll> findByDateRange(LocalDate start, LocalDate end) {

        // start date should not be before end date but they could be the same
        Preconditions.checkArgument(start.isBefore(end) || start.isEqual(end),
            "The start date is before the end date");

        // add one day and subtract 1ms to get the timestamp of the previous day at the end of the day
        return repository.findByInitiatedBetween(getMilliseconds(start), getMilliseconds(end.plusDays(1)) - 1);
    }

    public List<Poll> findFromDate(LocalDate start) {
        // subtract 1ms so the creation time is included
        return repository.findByInitiatedGreaterThan(getMilliseconds(start) - 1);
    }

    public List<Poll> findUntilDate(LocalDate end) {
        // add 1ms so the creation time is included
        return repository.findByInitiatedLessThan(getMilliseconds(end) + 1);
    }

    public List<Poll> findByTitleContains(String title) {
        return repository.findAllByTitleContains(title);

    }

    private long getMilliseconds(LocalDate date) {
        return date.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();
    }
}
