package com.jelvix.pages;/* Created by user on 21.07.20 */

public enum PagePaths {
    MAIN(""), BLOG("blog"), COMPANY("company"), CASE_STUDIES("case-studies"), CONTACT_US("contact-us"),
    TECHNOLOGIES("technologies"), EXPERTISE("expertise"), SERVICES("services"), INDUSTRIES("industries");
    private String link;

    PagePaths(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }


}

