package de.framework.commons.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 12.07.12
 * Time: 22:57
 * To change this template use File | Settings | File Templates.
 */
public class StringUtil {

    public static boolean notEmpty(String string) {
        return string != null && !string.trim().isEmpty();
    }

    public static String ensureNotNull(String string) {

        if(string == null) {
            return "";
        }

        return string;
    }

    public static String toString(InputStream inputStream) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;

        try {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
        } catch (IOException e) {
            return null;
        } finally {

            try {
                bufferedReader.close();
            } catch (IOException e) {
                return null;
            }

        }

        return stringBuilder.toString();
    }

}
