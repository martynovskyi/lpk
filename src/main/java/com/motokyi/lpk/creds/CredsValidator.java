package com.motokyi.lpk.creds;

import java.net.MalformedURLException;
import java.net.URL;

import static java.util.Objects.isNull;

public class CredsValidator {
    public static boolean isValid(CredsType type, String value) {
        if (isNull(value)) {
            return false;
        }
        switch (type) {
            case URL: {
                if (!value.isBlank()) {
                    try {
                        new URL(value);
                        return true;
                    } catch (MalformedURLException e) {
                        return false;
                    }
                }
                return false;
            }

            case NAME: {
                return !value.isBlank();
            }

            case LOGIN: {
                return !value.isBlank();
            }

            case PASSWORD: {
                return !value.isBlank() && value.length() >= 8;
            }
        }
        return false;
    }
}
