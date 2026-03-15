package mar14.Notification;

import mar14.User;

public class SMS extends Notification {

    public SMS(String message, User sender, User receiver) {
        super(message, sender, receiver);
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public Object getSenderId() {
        return sender.getPhoneNumber();
    }

    @Override
    public String getReceiverId() {
        return receiver.getPhoneNumber();
    }

    @Override
    public void setIsRead(boolean isRead) {
        this.isRead =  isRead;
    }

    @Override
    public String sendNotification() {
        return "MESSAGE:"+getMessage()+" | TO:"+getReceiverId();
    }

    @Override
    public String ReceiveNotification() {
        Object phNum = this.getSenderId();
        if(!(phNum instanceof String)) {return null;}

        String message;
        if(getMessage().length() > 10) message = getMessage().substring(0, 10)+"...";
        else message = getMessage();

        return "[SMS]::MESSAGE:"+message+" | FROM:"+phNum;
    }
}
