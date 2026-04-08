package DesignPatterns.BehavioralDesign.State.States;

import DesignPatterns.BehavioralDesign.State.DocumentState;
import DesignPatterns.BehavioralDesign.State.Document;

public class DraftState implements DocumentState {
    @Override
    public void edit(Document context, String content) {
        System.out.println("Editing document: " + content);
        context.setContent(content);
    }

    @Override
    public void submitForReview(Document context) {
        System.out.println("Document submitted for review.");
        context.setState(new UnderReviewState());
    }

    @Override
    public void approve(Document context) {
        System.out.println("Cannot approve a draft. Submit for review first.");
    }

    @Override
    public void reject(Document context) {
        System.out.println("Cannot reject a draft. Submit for review first.");
    }

    @Override
    public void unpublish(Document context) {
        System.out.println("Document is already a draft.");
    }
}
