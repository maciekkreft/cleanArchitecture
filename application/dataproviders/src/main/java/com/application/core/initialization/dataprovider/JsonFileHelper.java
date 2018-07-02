package com.application.core.initialization.dataprovider;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonFileHelper {
    private static final String DIRECTORY = "dictionaries/";

    public static String getJson(final String filename) throws URISyntaxException, IOException {
        URL resource = JsonFileHelper.class.getClassLoader().getResource(DIRECTORY + filename);
        Path path = null;
        if (resource != null) {
            path = Paths.get(resource.toURI());
            return new String(Files.readAllBytes(path));
        }
        throw new FileNotFoundException(filename);
    }
}
