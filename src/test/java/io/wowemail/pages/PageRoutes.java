package io.wowemail.pages;/* Created by user on 25.08.20 */

public enum PageRoutes {
    MAIN(""), HOW_WE_WORK("how-we-work"), SAMPLES("samples"), FAQ("faq"), CONTACT("contact"), ORDER_NOW("order-now"),
    CLIENT_AREA("client-area");
    private String route;

    PageRoutes(String route) {
        this.route = route;
    }

    public String getRoute() {
        return route;
    }
}
