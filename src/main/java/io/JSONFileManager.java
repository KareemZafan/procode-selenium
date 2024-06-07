package io;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JSONFileManager {
    private JsonNode rootNode;
    private ReadContext readContext;

    public JSONFileManager(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        rootNode = objectMapper.readTree(new File(filePath));
        readContext = JsonPath.parse(rootNode.toString());
    }

    public Object getObject(String jsonPath) throws IOException {
        return readContext.read(jsonPath);
    }
}
