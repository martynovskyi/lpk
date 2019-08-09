package com.motokyi.lpk.creds;

import org.apache.commons.validator.routines.UrlValidator;

import static java.util.Objects.isNull;

public class CredsValidator {
    private static final String[] SCHEMES = {"http", "https"};
    private static final UrlValidator URL_VALIDATOR = new UrlValidator(SCHEMES);

    public static boolean isValid(CredsType type, String value) {
        if (isNull(value)) {
            return false;
        }
        switch (type) {
            case URL: {
                if (!value.isBlank()) {
                    return URL_VALIDATOR.isValid(value);
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
