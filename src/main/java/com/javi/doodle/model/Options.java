package com.javi.doodle.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Options {

    private String text;

    private Boolean available;

    private BigDecimal start;

    private Boolean allday;

    private BigDecimal date;

    private String end;

    private String startDate;

    private String endDate;
}

