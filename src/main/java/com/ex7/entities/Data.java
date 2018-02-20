package com.ex7.entities;

import com.epam.commons.DataClass;
import com.ex7.enums.*;

import java.util.List;

public class Data extends DataClass {
    private List<NumbersEnum> summary;
    private List<ElementsEnum> elements;
    private ColoursEnum colour;
    private MetalsEnum metals;
    private List<SaladEnum> salad;

    public Data(List<NumbersEnum> summary, List<ElementsEnum> elements, ColoursEnum colour, MetalsEnum metals, List<SaladEnum> salad) {
        this.summary = summary;
        this.elements = elements;
        this.colour = colour;
        this.metals = metals;
        this.salad = salad;
    }

    public List<NumbersEnum> getSummary() {
        return summary;
    }

    public List<ElementsEnum> getElements() {
        return elements;
    }

    public ColoursEnum getColour() {
        return colour;
    }

    public MetalsEnum getMetals() {
        return metals;
    }

    public List<SaladEnum> getSalad() {
        return salad;
    }
}