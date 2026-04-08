package DesignPatterns.BehavioralDesign.State;

import DesignPatterns.BehavioralDesign.State.States.DraftState;

public class Document {
    private DocumentState currentState;
    private String content;

    public Document() {
        this.currentState = new DraftState();
        this.content = "";
    }

    public void setState(DocumentState state) { this.currentState = state; }
    public void setContent(String content) { this.content = content; }
    public String getContent() { return content; }

    public void edit(String content) { currentState.edit(this, content); }
    public void submitForReview() { currentState.submitForReview(this); }
    public void approve() { currentState.approve(this); }
    public void reject() { currentState.reject(this); }
    public void unpublish() { currentState.unpublish(this); }
}
