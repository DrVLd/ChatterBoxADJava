package core;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class Message {
    private long messageID;
    private String textMessage;
    private User msgReceiver;
    private User msgSender;
    private Chat chatField;
    private List<Attachment> attachments;
    private LocalDateTime messsageDT;

    public Message(long messageID, String textMessage, User msgReceiver, User msgSender, Chat chatField, LocalDateTime messsageDT) {
        this.messageID = messageID;
        this.textMessage = textMessage;
        this.msgReceiver = msgReceiver;
        this.msgSender = msgSender;
        this.chatField = chatField;
        this.attachments = new LinkedList<>();
        this.messsageDT = messsageDT;
    }

    public void addAttachment(Attachment attachment)
    {
        attachments.add(attachment);
    }

    public long getMessageID() {
        return messageID;
    }

    public void setMessageID(long messageID) {
        this.messageID = messageID;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public User getMsgReceiver() {
        return msgReceiver;
    }

    public void setMsgReceiver(User msgReceiver) {
        this.msgReceiver = msgReceiver;
    }

    public User getMsgSender() {
        return msgSender;
    }

    public void setMsgSender(User msgSender) {
        this.msgSender = msgSender;
    }

    public Chat getChatField() {
        return chatField;
    }

    public void setChatField(Chat chatField) {
        this.chatField = chatField;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public LocalDateTime getMesssageDT() {
        return messsageDT;
    }

    public void setMesssageDT(LocalDateTime messsageDT) {
        this.messsageDT = messsageDT;
    }
}
