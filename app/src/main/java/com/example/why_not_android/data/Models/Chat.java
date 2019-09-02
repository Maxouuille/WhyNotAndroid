package com.example.why_not_android.data.Models;

public class Chat {
    public String emailSender;
    public String emailReciver;
    public String message;
    public String date;

    public String getEmailSender() {
        return emailSender;
    }

    public void setEmailSender(String emailSender) {
        this.emailSender = emailSender;
    }

    public String getEmailReciver() {
        return emailReciver;
    }

    public void setEmailReciver(String emailReciver) {
        this.emailReciver = emailReciver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Chats{" +
                "emailSender='" + emailSender + '\'' +
                ", emailReciver='" + emailReciver + '\'' +
                ", message='" + message + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
