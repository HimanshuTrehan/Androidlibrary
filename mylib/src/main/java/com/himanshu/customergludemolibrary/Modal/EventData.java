package com.himanshu.customergludemolibrary.Modal;

import android.content.Intent;

public class EventData {

 String event_id;
 String user_id;
 String timestamp;
    String event_name;
    EventProperties event_properties;

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public void setEventProperties(EventProperties eventProperties) {
        this.event_properties = eventProperties;
    }




 public static class EventProperties
 {
    String state;

     public void setState(String state) {
         this.state = state;
     }
 }

}
