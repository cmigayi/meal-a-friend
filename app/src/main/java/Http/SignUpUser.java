package Http;

import java.util.HashMap;

import Common.User;
import Interfaces.UrlCallback;

public class SignUpUser extends HandleJsonDataFromServer{
    ServerRequest serverRequest;
    String url;
    HashMap<String,String> data;

    public User postUserInfo(User user){
        url = "/createUser";
        data = new HashMap<String, String>();
        data.put("fname",user.getFname());
        data.put("lname",user.getLname());
        data.put("email",user.getEmail());
        data.put("phone",user.getPhone());
        data.put("password",user.getPwd());

        serverRequest = new ServerRequest(url, data, new UrlCallback() {
            @Override
            public void done(String result) {
                if(result == null){

                }else{

                }
            }
        });
        return user;
    }
}
