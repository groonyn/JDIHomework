package com.ex8.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.ex8.entities.MetalsColoursVegetables;
import com.ex8.utils.Utils;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.*;

public class MetalColoursResultSection extends Section {
    @FindBy(css = ".results li")
    private TextList actualResults;

    public static Map<String, Object> provideExpectedResult(MetalsColoursVegetables metalsColoursVegetables) {
        Map<String, Object> expectedResultMap = new HashMap<>();
        expectedResultMap.put("Summary", String.valueOf(Utils.summOfList(metalsColoursVegetables.getSummary())));
        expectedResultMap.put("Elements", metalsColoursVegetables.getElements());
        expectedResultMap.put("Color", metalsColoursVegetables.getColor());
        expectedResultMap.put("Metal", metalsColoursVegetables.getMetals());
        expectedResultMap.put("Vegetables", metalsColoursVegetables.getVegetables());
        return expectedResultMap;
    }

    @SuppressWarnings("unchecked")
    public void checkResult(Map<String, Object> expectedResult) {
        List<String> actualResultList = new ArrayList<>();
        List<String> expectedResultList = new ArrayList<>();

        for (Object item : actualResults.getElements().toMap().keySet()) {
            String[] keyValueSet = ((String) item).split(": ");
            String value = keyValueSet[1];

            if (value.contains(",")) {
                List<String> listValue = Arrays.asList(value.split(", "));
                actualResultList.addAll(listValue);

            } else {
                actualResultList.add(value);
            }
        }

        for (Map.Entry<String, Object> entry : expectedResult.entrySet()) {
            if (entry.getValue() instanceof Iterable) {
                expectedResultList.addAll(((List<String>) entry.getValue()));
            } else {
                expectedResultList.add((String) entry.getValue());
            }
        }

        Collections.sort(expectedResultList);
        Collections.sort(actualResultList);

        Assert.assertEquals(expectedResultList, actualResultList);
    }
}