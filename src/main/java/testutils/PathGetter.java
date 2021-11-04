package testutils;

import configreader.ConfigManager;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathGetter {
    public static String getAbsoluteFilePath(String pathProperty, String fileName) throws IOException {
        String pathFromProperty = ConfigManager.getProperty(pathProperty);
        String fileRelativePath = pathFromProperty + fileName;
        Path filePath = Paths.get(fileRelativePath).toAbsolutePath();
        return filePath.toString();
    }

    public static String getAbsoluteFolderPath(String pathProperty) throws IOException {
        String pathFromProperty = ConfigManager.getProperty(pathProperty);
        Path absolutePath = Paths.get(pathFromProperty).toAbsolutePath();
        return absolutePath.toString();
    }
}
