package com.keychat.controller.util;

import com.google.gson.*;
import com.google.gson.internal.Primitives;
import com.keychat.dto.base.ChannelsChatHistoryModel;
import com.keychat.dto.util.ResponseModel;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

public class JsonUtil {
    public static <T> T getModelFromJsonRequest(HttpServletRequest request, Class<T> classOfT) throws JsonSyntaxException, IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(request.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String buffer;
        while ((buffer = input.readLine()) != null) {
            if (builder.length() > 0) {
                builder.append("\n");
            }
            builder.append(buffer);
        }

        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(new String(builder.toString().getBytes("8859_1"),"euc-kr"));
        String jsonRequest = element.getAsJsonObject().get("requestMsg").getAsJsonObject().toString();

        Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd").create();

        Object object = gson.fromJson(jsonRequest, (Type)classOfT);
        return Primitives.wrap(classOfT).cast(object);
    }
}
