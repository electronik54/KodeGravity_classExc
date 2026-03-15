package mar14.Notification;

import mar14.User;

public class Email extends Notification {

    private final String subject;

    public Email(String subject, String message, User sender, User receiver) {
        super(message, sender, receiver);
        this.subject = subject;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
    public String getSubject() {
        return this.subject;
    }

    //region -SENDER METHODS-
    @Override
    public Object getSenderId() {
        return sender.getUserEmail();
    }
    //endregion

    //region -RECEIVER METHODS-
    @Override
    public String getReceiverId() {
        return receiver.getUserEmail();
    }
    //endregion

    @Override
    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    @Override
    public String sendNotification() {
        return "SUBJECT:"+getSubject()+" | MESSAGE:"+getMessage()+" | TO:"+getReceiverId();
    }

    @Override
    public String ReceiveNotification() {
        Object email = this.getSenderId();
        if(!(email instanceof String)) {return null;}

        String message;
        if(getMessage().length() > 10) message = getMessage().substring(0, 10)+"...";
        else message = getMessage();

        return "[EMAIL]::MESSAGE:"+message+" | FROM:"+email;
    }
}
