package com.intellij.boot.model;

public class EmailBean {

    private String to;
    private String subject;
    private String message;

    public EmailBean(String to, String subject, String message) {

        this.to = to;
        this.subject = subject;
        this.message = message;
    }

    public EmailBean() {
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "EmailBean{" +
                "to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
