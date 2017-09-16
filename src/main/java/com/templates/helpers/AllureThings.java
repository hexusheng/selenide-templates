package com.templates.helpers;

import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;

import java.io.File;
import java.io.IOException;

public class AllureThings {

    private AllureThings() {
    }

    public static AllureThings exec() {
        return new AllureThings();
    }

    @Attachment("{name}")
    public byte[] makeScreenShot(String name) {

        File screenshot = Screenshots.takeScreenShotAsFile();
        try {
            return Files.toByteArray(screenshot);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
