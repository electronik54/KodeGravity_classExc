package mar14.Notification;

import mar14.User;

public class Push extends Notification {
    public Push(String message, User sender, User receiver) {
        super(message, sender, receiver);
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public Object getSenderId() {
        return sender.getUserId();
    }

    @Override
    public String getReceiverId() {
        return receiver.getUserId();
    }

    @Override
    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    @Override
    public String sendNotification() {
        return "MESSAGE:"+getMessage()+" | TO:"+getReceiverId();
    }

    @Override
    public String ReceiveNotification() {
        Object senId = this.getSenderId();
        if(!(senId instanceof String)) {return null;}

        String message;
        if(getMessage().length() > 10) message = getMessage().substring(0, 10)+"...";
        else message = getMessage();

        return "[PUSH]::MESSAGE:"+message+" | FROM:"+senId;
    }
}
