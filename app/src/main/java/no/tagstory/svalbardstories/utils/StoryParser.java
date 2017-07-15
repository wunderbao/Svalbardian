package no.tagstory.svalbardstories.utils;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;

import no.tagstory.svalbardstories.Story;

public class StoryParser {

    private static String loadJsonFromAsset(Context context) {
        String json;
        try {
            InputStream is = context.getAssets().open("svalbardian.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException exception) {
            exception.printStackTrace();
            return null;
        }
        return json;
    }

    public static Story parseStoryFromAssets(Context context) {
        Gson gson = new Gson();
        return gson.fromJson(loadJsonFromAsset(context), Story.class);
        //JsonParser jsonParser = new JsonParser();
        //JsonElement element = jsonParser.parse(loadJsonFromAsset(context));

        //Story story = new Story();
        //parseStoryHeader(element, story);
        //parseStoryTags(element, story);
        //return story;
    }

    private static void parseStoryHeader(JsonElement element, Story story) {
        JsonObject header = element.getAsJsonObject();
        //story.setUUID(header.get("UUID"));
        //story.
    }

    private static void parseStoryTags(JsonElement element, Story story) {
    }
}
