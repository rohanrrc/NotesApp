package com.rohan.notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rohan on 7/23/16.
 */
public class Note {
    private String title;
    private List<String> contents = new ArrayList<String>();

    public Note(){
    }

    public Note(String title, String contents){
        this.title = title;
        this.contents.add(contents);
    }

    public Note(String title, String... contents){
        this.title = title;
        this.contents = Arrays.asList(contents);
    }

    public String getTitle() {
        return title;
    }

    public List<String> getContents() {
        return contents;
    }
}
