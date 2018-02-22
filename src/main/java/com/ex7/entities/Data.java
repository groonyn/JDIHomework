package com.ex7.entities;

import com.epam.commons.DataClass;
import com.ex7.enums.*;
import lombok.Getter;

import java.util.List;

@Getter
public class Data extends DataClass {
    private final List<NumbersEnum> summary;
    private final List<ElementsEnum> elements;
    private final ColoursEnum colour;
    private final MetalsEnum metals;
    private final List<SaladEnum> salad;

    public Data(List<NumbersEnum> summary, List<ElementsEnum> elements, ColoursEnum colour, MetalsEnum metals, List<SaladEnum> salad) {
        this.summary = summary;
        this.elements = elements;
        this.colour = colour;
        this.metals = metals;
        this.salad = salad;
    }
}