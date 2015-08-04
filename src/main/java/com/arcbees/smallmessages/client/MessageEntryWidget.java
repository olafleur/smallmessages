package com.arcbees.smallmessages.client;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.*;

public class MessageEntryWidget implements IsWidget, KeyUpHandler {
    private final String CHARACTERS_LEFT = "Characters left : ";
    private final int MAX_CHARACTERS = 150;

    private TextArea messageText = new TextArea();
    private HorizontalPanel horizontalPanel = new HorizontalPanel();
    private Button publishButton = new Button();
    private VerticalPanel verticalPanel = new VerticalPanel();
    private Label charactersLeft = new Label(CHARACTERS_LEFT + String.valueOf(MAX_CHARACTERS));

    public MessageEntryWidget() {
        publishButton.setText("Publish");

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
}
