package com.example.why_not_android.data.dto;

import com.google.gson.annotations.SerializedName;

public class ChatDTO {

    @SerializedName("emailSender") private String emailSender;
    @SerializedName("emailReciver") private String emailReciver;
    @SerializedName("message") private String message;
    @SerializedName("date") private String date;

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
}
