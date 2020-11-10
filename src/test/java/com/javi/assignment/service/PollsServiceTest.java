package com.javi.assignment.service;

import com.javi.assignment.exception.NotSupportedException;
import com.javi.assignment.mapper.PollMapper;
import com.javi.assignment.mapper.PollMapperImpl;
import com.javi.assignment.model.Poll;
import com.javi.assignment.model.PollResponse;
import com.javi.assignment.repository.PollRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PollsServiceTest {

    PollsService pollsService;

    @Mock
    PollRepository repository;

    final PollMapper mapper = new PollMapperImpl();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        pollsService = new PollsService(repository, mapper);

    }

    @Test(expected = NotSupportedException.class)
    public void testNotImplemented() throws NotSupportedException {

        // all params search is not supported
        pollsService.search("x", LocalDate.now(), LocalDate.now());

        // should not reach here
        fail();
    }

    @Test()
    public void searchByDateRange() throws NotSupportedException {

        final LocalDate startDate = LocalDate.parse("2020-10-10");
        final LocalDate endDate = LocalDate.parse("2010-10-12");

        final String id0 = "0";
        final String id1 = "1";

        Poll pollDto0 = new Poll();
        Poll pollDto1 = new Poll();
        pollDto0.setId(id0);
        pollDto1.setId(id1);

        List<Poll> result = Arrays.asList(pollDto0, pollDto1);

        // mocked result from repository method
        when(repository.findByDateRange(startDate, endDate)).thenReturn(result);

        List<PollResponse> search = pollsService.search(null, startDate, endDate);

        assertThat(search.size(), is(2));
        assertThat(search.get(0).getId(), is(id0));
        assertThat(search.get(1).getId(), is(id1));
    }
}
