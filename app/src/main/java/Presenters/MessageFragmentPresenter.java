package Presenters;

import java.util.ArrayList;

import Common.Message;
import Repositories.MessageRepository;
import Views.MessagesFragmentView;

public class MessageFragmentPresenter {

    MessagesFragmentView view;
    MessageRepository repository;

    public MessageFragmentPresenter(MessagesFragmentView view, MessageRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void loadMessages() {
        ArrayList<Message> messagesList = repository.getMessages();

        if(messagesList == null){
            view.displayNoMessages();
        }else{
            if(messagesList.size() > 0){
                view.displayMessages();
            }else{
                view.displayNoMessages();
            }
        }
    }
}
