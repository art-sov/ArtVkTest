package com.art.artvktest.model.view.counter;

import com.art.artvktest.model.Reposts;

public class RepostCounterViewModel extends CountViewModel {

    private Reposts mReposts;


    public RepostCounterViewModel(Reposts reposts) {
        super(reposts.getCount());
        this.mReposts = reposts;
        if (mReposts.getUserReposted() == 1) {
            setAccentColor();
        }
    }

    public Reposts getReposts() {
        return mReposts;
    }
}
