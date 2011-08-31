package net.efano.dominco.ui.sandbox;

/******************************************************************************
 * All Right Reserved. 
 * Copyright (c) 1998, 2004 Jackwind Li Guojie
 * 
 * Created on 2004-4-9 14:11:34 by JACK
 * $Id$
 * 
 * http://www.java2s.com/Code/Java/SWT-JFace-Eclipse/TabFolderExample.htm
 * 
 *****************************************************************************/

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

public class TabFolderJack {

	Display display = new Display();
  Shell shell = new Shell(display);
  
  Image icon = new Image(shell.getDisplay(), "java2s.gif");

  public TabFolderJack() {
    shell.setLayout(new FillLayout());
    
    final TabFolder tabFolder = new TabFolder(shell, SWT.BOTTOM);
    
    
    Button button = new Button(tabFolder, SWT.NULL);
    button.setText("This is a button.");
    
    TabItem tabItem1 = new TabItem(tabFolder, SWT.NULL);
    tabItem1.setText("item #1");
    tabItem1.setImage(icon);
    tabItem1.setControl(button);
    
    Text text = new Text(tabFolder, SWT.MULTI);
    text.setText("This is a text control.");
    
    TabItem tabItem2 = new TabItem(tabFolder, SWT.NULL);
    tabItem2.setText("item #2");
    tabItem2.setImage(icon);
    tabItem2.setControl(text);
    
    Label label = new Label(tabFolder, SWT.NULL);
    label.setText("This is a text lable.");
    
    TabItem tabItem3 = new TabItem(tabFolder, SWT.NULL);
    tabItem3.setText("item #3");
    tabItem3.setControl(label);
    
    tabFolder.addSelectionListener(new SelectionListener() {
      public void widgetSelected(SelectionEvent e) {
        System.out.println("Selected item index = " + tabFolder.getSelectionIndex());
        System.out.println("Selected item = " + (tabFolder.getSelection() == null ? "null" : tabFolder.getSelection()[0].toString()));
      }

      public void widgetDefaultSelected(SelectionEvent e) {
        widgetSelected(e);
      }
    });

    //tabFolder.setSelection(new TabItem[]{tabItem2, tabItem3});
    //tabFolder.setSelection(2);
    
    shell.setSize(400, 120);
    shell.open();
    //textUser.forceFocus();
    
    System.out.println(tabFolder.getSelectionIndex());

    // Set up the event loop.
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        // If no more entries in event queue
        display.sleep();
      }
    }

    display.dispose();
  }

  private void init() {

  }

  public static void main(String[] args) {
    new TabFolderJack();
  }

}
