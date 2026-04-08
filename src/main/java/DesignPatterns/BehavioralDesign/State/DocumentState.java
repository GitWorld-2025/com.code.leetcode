package DesignPatterns.BehavioralDesign.State;

public interface DocumentState {
    void edit(Document context, String content);
    void submitForReview(Document context);
    void approve(Document context);
    void reject(Document context);
    void unpublish(Document context);
}
