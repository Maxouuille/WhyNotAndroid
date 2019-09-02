package com.example.why_not_android.data.dto;

import com.google.gson.annotations.SerializedName;

public class MessageDTO {

    @SerializedName("message")
    private String message;
    @SerializedName("emailSender")
    private String emailSender;
    @SerializedName("emailReciver")
    private String emailReciver;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

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

    @Override
    public String toString() {
        return "MessageDTO{" +
                "message='" + message + '\'' +
                ", emailSender='" + emailSender + '\'' +
                ", emailReciver='" + emailReciver + '\'' +
                '}';
    }
}
