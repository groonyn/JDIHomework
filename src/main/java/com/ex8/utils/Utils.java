package com.ex8.utils;

import com.ex8.entities.Data;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<Data> jsonGetData() throws IOException {
        String s = Files.toString(new File("src\\main\\resources\\ex8_jdi_metalsColorsDataSet.json"), Charset.defaultCharset());
        Gson gson = new Gson();
        Type type = new TypeToken<LinkedTreeMap<String, Data>>() {
        }.getType();
        LinkedTreeMap<String, Data> result = gson.fromJson(s, type);
        return new ArrayList<>(result.values());
    }

    public static int summOfList(List<Integer> summary){
        return summary.stream().mapToInt(Integer::intValue).sum();
    }
}