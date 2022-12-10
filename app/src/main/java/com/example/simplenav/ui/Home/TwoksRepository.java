package com.example.simplenav.ui.Home;

import java.util.ArrayList;
import java.util.List;

public class TwoksRepository {//è il model

    private List<String> twokList = null;

    public TwoksRepository() {
        this.twokList = new ArrayList<String>();
    }

    public String getTwokList(int pos) {
        return twokList.get(pos);
    }

    public int getSize(){
        return twokList.size();
    }

    public void initWithFakeData(){
        for (int i = 0; i < 100; i++) {
            twokList.add("Entry Twok"+i);
        }
    }

}
