package com.arcbees.smallmessages.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class MessageWidget implements IsWidget {
    interface MyUiBinder extends UiBinder<Widget, MessageWidget> {}
    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

    @UiField
    HTMLPanel htmlPanel;

    @UiField(provided = true)
    Label messageLabel;

    public MessageWidget(String message) {
        messageLabel = new Label(message);

        uiBinder.createAndBindUi(this);
    }

    public Widget asWidget() {
        return htmlPanel;
    }
}
