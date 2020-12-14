package io.wowemail.tests.environment;/* Created by user on 25.08.20 */

public class Environment {

    public String getEnvironment(EnvironmentLinks link) {
        switch (link) {
            case STAGE:
                return "";
            case DEV:
                return "";
            case PRODUCTION:
                return "https://wowemail.io/";
            default:
                throw new IllegalArgumentException("Wrong link" + link);
        }
    }
}
