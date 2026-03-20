package mar17.SocialMedia;

import mar17.User;

public interface IntChat {
    public String sendChat(String message, User toUser);
    public String receiveChat();
}
