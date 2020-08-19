package com.example.cadiapp2.items;

public class NoticeItems {
    String title;
    String contents;

    public NoticeItems(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }
}
