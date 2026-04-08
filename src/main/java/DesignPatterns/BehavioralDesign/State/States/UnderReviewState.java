package DesignPatterns.BehavioralDesign.State.States;

import DesignPatterns.BehavioralDesign.State.Document;
import DesignPatterns.BehavioralDesign.State.DocumentState;

class UnderReviewState implements DocumentState {
    @Override
    public void edit(Document context, String content) {
        System.out.println("Cannot edit while under review.");
    }

    @Override
    public void submitForReview(Document context) {
        System.out.println("Document is already under review.");
    }

    @Override
    public void approve(Document context) {
        System.out.println("Document approved and published.");
        context.setState(new PublishedState());
    }

    @Override
    public void reject(Document context) {
        System.out.println("Document rejected. Returning to draft.");
        context.setState(new DraftState());
    }

    @Override
    public void unpublish(Document context) {
        System.out.println("Document is not published yet.");
    }
}
