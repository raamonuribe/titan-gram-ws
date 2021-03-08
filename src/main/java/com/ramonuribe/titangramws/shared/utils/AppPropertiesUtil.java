package com.ramonuribe.titangramws.shared.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AppPropertiesUtil {
    private final Environment env;

    @Autowired
    public AppPropertiesUtil(Environment env) {
        this.env = env;
    }

    public String getTokenSecret() {
        return env.getProperty("token.secret");
    }
}
