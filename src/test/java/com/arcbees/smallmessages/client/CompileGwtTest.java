package com.arcbees.smallmessages.client;

import com.google.gwt.junit.client.GWTTestCase;

public class CompileGwtTest extends GWTTestCase {
  
  @Override
  public String getModuleName() {
    return "com.arcbees.smallmessages.Project";
  }

  public void testSandbox() {
    assertTrue(true);
  }
  
}
