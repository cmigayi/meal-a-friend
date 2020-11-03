package Presenters;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import Common.Message;
import Repositories.MessageRepository;
import Views.MessagesFragmentView;

import static org.junit.Assert.*;

public class MessageFragmentPresenterTest {
    MessagesFragmentView view;
    MessageRepository repository;

    @Before
    public void setUp() throws Exception {
        //given
        view = new MockView();
    }

    @After
    public void tearDown() throws Exception {
        view = null;
    }

    @Test
    public void shouldPassMessagesToView(){
        //given
        repository = new MockMessageRepository(true);

        //when
        MessageFragmentPresenter presenter = new MessageFragmentPresenter(view,repository);
        presenter.loadMessages();

        //then
        Assert.assertEquals(true,((MockView)view).displayMessagesFound);

    }

    @Test
    public void shouldPassNoMessageNotFound(){
        //given
        MessageRepository repository = new MockMessageRepository(false);

        //when
        MessageFragmentPresenter presenter = new MessageFragmentPresenter(view,repository);
        presenter.loadMessages();

        //then
        Assert.assertEquals(true,((MockView)view).displayMessagesNotFound);
    }

    public class MockView implements MessagesFragmentView{
        Boolean displayMessagesFound;
        Boolean displayMessagesNotFound;

        @Override
        public void displayMessages() {
            displayMessagesFound = true;
        }

        @Override
        public void displayNoMessages() {
            displayMessagesNotFound=true;
        }
    }

    public class MockMessageRepository implements MessageRepository{
        Boolean returnSomething;

        public MockMessageRepository(Boolean returnSomething) {
            this.returnSomething = returnSomething;
        }

        @Override
        public ArrayList<Message> getMessages() {
            ArrayList<Message> messageList = new ArrayList<Message>();

            if(returnSomething == true){
                messageList.add(new Message());
                messageList.add(new Message());
            }
            return messageList;
        }
    }
}