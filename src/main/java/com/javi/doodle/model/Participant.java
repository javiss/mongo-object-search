package com.javi.doodle.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Participant {

    private BigDecimal id;

    private String name;

    private List<BigDecimal> preferences;

}

