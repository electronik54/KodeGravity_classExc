package mar17.SocialMedia;

import mar17.User;

public class LinkedIn implements IntChat, IntPost, IntAds{
    @Override
    public String sendChat(String message, User toUser) {
        return "";
    }

    @Override
    public String receiveChat() {
        return "";
    }

    @Override
    public String setPost(String image, String message) {
        return "";
    }

    @Override
    public String getPost() {
        return "";
    }
}
