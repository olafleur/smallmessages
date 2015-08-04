package com.arcbees.smallmessages.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

public class MessageEntryWidget implements IsWidget, KeyUpHandler, ClickHandler {
    private final String CHARACTERS_LEFT = "Characters left : ";
    private final int MAX_CHARACTERS = 150;

    private TextArea messageText = new TextArea();
    private HorizontalPanel horizontalPanel = new HorizontalPanel();
    private Button publishButton = new Button();
    private VerticalPanel verticalPanel = new VerticalPanel();
    private Label charactersLeft = new Label(CHARACTERS_LEFT + String.valueOf(MAX_CHARACTERS));

    public MessageEntryWidget() {
        publishButton.setText("Publish");
        publishButton.addClickHandler(this);

        messageText.getElement().setPropertyString("placeholder", "What are you thinking about?");
        messageText.addKeyUpHandler(this);

        horizontalPanel.add(messageText);
        horizontalPanel.add(publishButton);

        verticalPanel.add(horizontalPanel);
        verticalPanel.add(charactersLeft);
    }

    @Override
    public Widget asWidget() {
        return verticalPanel;
    }

    @Override
    public void onKeyUp(KeyUpEvent event) {
        updateCount();
    }

    private void updateCount() {
        charactersLeft.setText(CHARACTERS_LEFT + String.valueOf(MAX_CHARACTERS - messageText.getText().length()));
    }

    @Override
    public void onClick(ClickEvent event) {
        submitMessage();
    }

    private void submitMessage() {
        if(isValidMessage()) {
            addMessage(messageText.getText());
            messageText.setText("");
            updateCount();
        } else {
            Window.alert("Your message is invalid. Please enter between 1 and "
                    + String.valueOf(MAX_CHARACTERS) + " characters.");
        }
    }

    private void addMessage(String text) {
        verticalPanel.add(new MessageWidget(text));
        consoleLog("The user has published a new message : " + text);
    }

    private boolean isValidMessage() {
        return messageText.getText().length() <= MAX_CHARACTERS && messageText.getText().length() > 0;
    }

    private native void consoleLog(String message) /*-{
        $wnd.console.log(message);
    }-*/;
}
