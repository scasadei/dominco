package org.eclipse.swt.snippets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;

public class CreateWidgetPictureLabel extends Composite {

  Label image, text;
  Color white;


  CreateWidgetPictureLabel(Composite parent, int style) {
     super(parent, style);
     white = new Color(null, 255, 255, 255);
     image = new Label(this, 0);
     text = new Label(this, 0);

     setBackground(white);
     image.setBackground(white);
     text.setBackground(white);

     addDisposeListener(new DisposeListener() {
         public void widgetDisposed(DisposeEvent e) {
            CreateWidgetPictureLabel.this.widgetDisposed(e);
         }
     });
     
     addControlListener(new ControlAdapter() {
         public void controlResized(ControlEvent e) {
            CreateWidgetPictureLabel.this.controlResized(e);
         }
     });
  }

 
  public void widgetDisposed(DisposeEvent e) {
      white.dispose();
}

  void controlResized(ControlEvent e) {
	  resize();
  }

  void resize() {
	  Point iExtent = image.computeSize(SWT.DEFAULT, SWT.DEFAULT, false);
	  Point tExtent = text.computeSize(SWT.DEFAULT, SWT.DEFAULT, false);
	  image.setBounds(1, 1, iExtent.x, iExtent.y);
	  text.setBounds(iExtent.x + 5, 1, tExtent.x, tExtent.y);
  }

  public Image getImage() {
	  return image.getImage();
  }

  public void setImage(Image image) {
	  this.image.setImage(image);
	  resize();
  }


  public String getText() {
	  return text.getText();
  }

  public void setText(String text) {
	  this.text.setText(text);
	  resize();
  }

  public Point computeSize(int wHint, int hHint, boolean changed) {
	  Point iExtent = image.computeSize(SWT.DEFAULT, SWT.DEFAULT, false);
	  Point tExtent = text.computeSize(SWT.DEFAULT, SWT.DEFAULT, false);
	  int width = iExtent.x + 5 + tExtent.x;
	  int height = Math.max(iExtent.y, tExtent.y);
	  if (wHint != SWT.DEFAULT) width = wHint;
	  if (hHint != SWT.DEFAULT) height = hHint;         
	  return new Point(width + 2, height + 2);
  }

}
