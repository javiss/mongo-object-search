package com.javi.doodle.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "polls")
public class Poll {

    @Id
    private String id;

    private String adminKey;

    private Long latestChange;

    private Long initiated;

    private Integer participantsCount;

    private Integer inviteesCount;

    private String type;

    private Boolean hidden;

    private String preferencesType;

    private String state;

    private String locale;

    private String title;

    private Initiator initiator;

    private List<Options> options;

    private String optionsHash;

    private List<Participant> participants;
}

