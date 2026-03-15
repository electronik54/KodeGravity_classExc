package mar14.Notification;

import mar14.User;

public abstract class Notification {
    final String message;
    boolean isRead;
    final User sender;
    final User receiver;

    public Notification(String message, User sender, User receiver) {
        this.message = message;
        this.sender = sender;
        this.receiver = receiver;
        isRead = false;
    }

    public abstract String getMessage();
    public abstract Object getSenderId();
    public abstract String getReceiverId();
    public abstract void setIsRead(boolean isRead);
    public abstract String sendNotification();
    public abstract String ReceiveNotification();

}
