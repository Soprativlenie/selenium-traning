package io.wowemail.tests.environment;/* Created by user on 25.08.20 */

public class Environment {

    public String getEnvironment(EnvironmentLinks link) {
        switch (link) {
            case STAGE:
                return "http://31.202.123.239:3343/";
            case DEV:
                return "http://192.168.88.112/";
            case PRODUCTION:
                return "https://wowemail.io/";
            default:
                throw new IllegalArgumentException("Wrong link" + link);
        }
    }
}
