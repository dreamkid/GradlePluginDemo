package com.hezd.testapp;

/**
 * Created by hezd on 20-6-11 下午3:43
 */
public class EventData {
    public String event_type;
    public String session_id;

    public EventData(String event_type, String session_id) {
        this.event_type = event_type;
        this.session_id = session_id;
    }
}
