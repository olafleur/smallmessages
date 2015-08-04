package com.arcbees.smallmessages.client;

import com.google.gwt.user.client.ui.*;

/**
 * Created by olivierlafleur on 2015-08-04.
 */
public class MessageEntryWidget implements IsWidget {
    private TextArea messageText = new TextArea();
    private HorizontalPanel horizontalPanel = new HorizontalPanel();
    private Button publishButton = new Button();

    public MessageEntryWidget() {
        publishButton.setText("Publish");

        messageText.getElement().setPropertyString("placeholder", "What are you thinking about?");

        horizontalPanel.add(messageText);
        horizontalPanel.add(publishButton);
    }

    @Override
    public Widget asWidget() {
        return horizontalPanel;
    }
}
