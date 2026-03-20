package mar17.SocialMedia;

import mar17.User;

public class Facebook implements IntStory, IntChat, IntAds, IntPost {

    String message;
    String image;

    @Override
    public String sendChat(String message, User toUser) {
        return "SENDING MESSAGE"+message+" TO USER:"+toUser.getPhoneNumber();
    }

    @Override
    public String receiveChat() {
        return "RECEIVING MESSAGE"+this.message;
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

    @Override
    public String setPost(String image, String message) {
        return "SETTING POST:"+image + " MESSAGE:"+message;
    }

    @Override
    public String getPost() {
        return "GETTING POST:"+image + " MESSAGE:"+message;
    }
}
