package DesignPatterns.BehavioralDesign.State.States;

import DesignPatterns.BehavioralDesign.State.Document;

public class DocumentApp {
    public static void main(String[] args) {
        Document doc = new Document();

        doc.edit("First draft of the article.");
        doc.approve();              // Rejected: cannot approve a draft
        doc.submitForReview();
        doc.edit("Trying to edit");  // Rejected: under review
        doc.reject();                // Back to draft
        doc.edit("Revised draft.");
        doc.submitForReview();
        doc.approve();               // Published
        doc.edit("Trying to edit");  // Rejected: published
        doc.unpublish();             // Back to draft
    }
}
