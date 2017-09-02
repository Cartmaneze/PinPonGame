package view;

import com.sun.javafx.application.LauncherImpl;

import java.io.IOException;

/**
 * Created by Никита on 07.08.2017.
 */
public class MainWindow {
    public static void main(String[] args) throws IOException {
        LauncherImpl.launchApplication(Field.class, args);
    }
}
