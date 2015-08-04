package com.arcbees.smallmessages.client;

import com.arcbees.smallmessages.client.resources.Resources;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ProjectEntryPoint implements EntryPoint {
  
  @Override
  public void onModuleLoad() {
    Resources.INSTANCE.styles().ensureInjected();

    Label titleLabel = new Label();

    titleLabel.setText("Small messages application");
    titleLabel.setStyleName(Resources.INSTANCE.styles().title());

    RootPanel.get().add(titleLabel);
    RootPanel.get().add(new MessageEntryWidget());
  }

}
