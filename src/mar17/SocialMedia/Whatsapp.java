package mar17.SocialMedia;

import mar17.User;

public class Whatsapp implements IntChat, IntStory {

    String image;
    String message;

    @Override
    public String sendChat(String message, User toUser) {
        this.message = message;
        return "SENDING MESSAGE"+message+" TO USER:"+toUser.getPhoneNumber();
    }

    @Override
    public String receiveChat() {
        return "RECEIVING MESSAGE"+message;
    }

    @Override
    public String setStory(String image) {
        this.image = image;
        return "SETTING STORY:"+image;
    }

    @Override
    public String getStory() {
        return "GETTING STORY:"+image;
    }
}
