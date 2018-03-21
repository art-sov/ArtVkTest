package com.art.artvktest.model.view.counter;

import com.art.artvktest.model.Comments;

public class CommentCounterViewModel extends CountViewModel {
    private Comments mComments;


    public CommentCounterViewModel(Comments comments) {
        super(comments.getCount());
        this.mComments = comments;
    }

    public Comments getComments() {
        return mComments;
    }
}
