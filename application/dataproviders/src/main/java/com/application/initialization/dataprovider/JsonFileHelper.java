package com.application.initialization.dataprovider;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

public class JsonFileHelper {
    private static final String DIRECTORY = "dictionaries/";

    public static String getJson(final String filename) throws URISyntaxException, IOException {
        InputStream stream = JsonFileHelper.class.getClassLoader().getResourceAsStream(DIRECTORY + filename);
        return IOUtils.toString(stream, "UTF-8");
    }
}
