package com.ex8.utils;

import com.ex8.entities.Data;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<Data> jsonGetData() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src\\main\\resources\\ex8_jdi_metalsColorsDataSet.json");
        String s = IOUtils.toString(fileInputStream, Charset.defaultCharset());
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