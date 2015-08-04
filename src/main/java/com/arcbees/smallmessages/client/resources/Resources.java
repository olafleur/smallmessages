package com.arcbees.smallmessages.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface Resources extends ClientBundle {
    Resources INSTANCE = GWT.create(Resources.class);

    interface Styles extends CssResource {
        String border();

        String title();
    }

    Styles styles();

    @Source("logo.jpg")
    ImageResource logo();
}
