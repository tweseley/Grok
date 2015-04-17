package com.emotionalcommunication.tamarweseley.grok;


public class Messages {

    private int _id;
    private String _messageEmotion;

    public Messages(String _messageEmotion){
        this._messageEmotion = _messageEmotion;
    }

    public void set_id(int _id){
        this._id = _id;

    }
    public void set_messageEmotion(String _messageEmotion){
        this._messageEmotion = _messageEmotion;
    }

    public int get_id(){
        return _id;
    }

    public String get_messageEmotion(){
        return _messageEmotion;
    }
}
