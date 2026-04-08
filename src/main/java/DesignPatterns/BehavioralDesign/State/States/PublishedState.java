package DesignPatterns.BehavioralDesign.State.States;

import DesignPatterns.BehavioralDesign.State.Document;
import DesignPatterns.BehavioralDesign.State.DocumentState;

class PublishedState implements DocumentState {
    @Override
    public void edit(Document context, String content) {
        System.out.println("Cannot edit a published document. Unpublish first.");
    }

    @Override
    public void submitForReview(Document context) {
        System.out.println("Document is already published.");
    }

    @Override
    public void approve(Document context) {
        System.out.println("Document is already published.");
    }

    @Override
    public void reject(Document context) {
        System.out.println("Cannot reject a published document.");
    }

    @Override
    public void unpublish(Document context) {
        System.out.println("Document unpublished. Returning to draft.");
        context.setState(new DraftState());
    }
}
