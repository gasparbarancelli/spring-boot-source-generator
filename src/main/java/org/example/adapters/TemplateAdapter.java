package org.example.adapters;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.example.data.Template;

import java.io.FileNotFoundException;
import java.io.FileReader;

/***
 * Class to handle the template search
 */
public class TemplateAdapter {

    /***
     *
     * @param templatePath for fetching the correct file
     * @return Template
     * @throws RuntimeException if file is not found
     */
    public static Template findTemplate(String templatePath) {
        try {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(templatePath));
            return gson.fromJson(reader, Template.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Template not found");
        }
    }
}
