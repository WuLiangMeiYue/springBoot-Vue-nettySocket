package com.test.entity;

public class MessageInfo {
    private String sourceClientId;
    private String targetClientId;
    private String msgType;
    private String msgContext;

    public String getSourceClientId() {
        return sourceClientId;
    }

    public void setSourceClientId(String sourceClientId) {
        this.sourceClientId = sourceClientId;
    }

    public String getTargetClientId() {
        return targetClientId;
    }

    public void setTargetClientId(String targetClientId) {
        this.targetClientId = targetClientId;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgContext() {
        return msgContext;
    }

    public void setMsgContext(String msgContext) {
        this.msgContext = msgContext;
    }

    @Override
    public String toString() {
        return "MessageInfo{" +
                "sourceClientId='" + sourceClientId + '\'' +
                ", targetClientId='" + targetClientId + '\'' +
                ", msgType='" + msgType + '\'' +
                ", msgContext='" + msgContext + '\'' +
                '}';
    }
}
