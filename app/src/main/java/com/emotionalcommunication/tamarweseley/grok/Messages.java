package com.emotionalcommunication.tamarweseley.grok;


public class Messages {

    private int _id;
    private String _messageEmotion;
    private String _receivingUser;
    private String _sendingUser;
    private int _dateTime;

    public Messages(String messageEmotion, String receivingUser, String sendingUser){
        this._messageEmotion = messageEmotion;
        this._receivingUser = receivingUser;
        this._sendingUser = sendingUser;
    }

    public void set_id(int _id){
        this._id = _id;

    }
    public void set_messageEmotion(String _messageEmotion){
        this._messageEmotion = _messageEmotion;
    }

    public void set_receivingUser(String _receivingUser){
        this._receivingUser = _receivingUser;
    }

    public void set_sendingUser(String _sendingUser){
        this._sendingUser = _sendingUser;
    }

    public int get_id(){
        return _id;
    }

    public String get_messageEmotion(){
        return _messageEmotion;
    }

    public String get_receivingUser() { return _receivingUser; }

    public String get_sendingUser() { return _sendingUser; }
}
