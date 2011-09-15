package net.efano.dominco.ui.widget;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;

/*
 * From 
 * http://www.eclipse.org/articles/Article-Writing%20Your%20Own%20Widget/Writing%20Your%20Own%20Widget.htm
 */

public class StackedScrollableTables extends Composite {

  Label image, text;
  Color white;

  Table table;
  Table table_1;
  
  StackedScrollableTables(Composite parent, int style) {
     super(parent, style);
     
     
	 // SashForm sashForm_2 = new SashForm(this, SWT.NONE);
		SashForm sashForm = new SashForm(this, SWT.NONE);
		sashForm.setOrientation(SWT.VERTICAL);

		ScrolledComposite scrolledComposite_2 = new ScrolledComposite(sashForm, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		// ScrolledComposite scrolledComposite_2 = new ScrolledComposite(scrolledComposite, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite_2.setExpandHorizontal(true);
		scrolledComposite_2.setExpandVertical(true);
		
		table_1 = new Table(scrolledComposite_2, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		TableColumn tblclmnContext = new TableColumn(table_1, SWT.NONE);
		tblclmnContext.setWidth(100);
		tblclmnContext.setText("context");
		
		TableItem tableItem = new TableItem(table_1, SWT.NONE);
		tableItem.setText("Date");
		
		TableItem tableItem_1 = new TableItem(table_1, SWT.NONE);
		tableItem_1.setText("15.09.2011");
		scrolledComposite_2.setContent(table_1);
		scrolledComposite_2.setMinSize(table_1.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		ScrolledComposite scrolledComposite_1 = new ScrolledComposite(sashForm, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite_1.setExpandHorizontal(true);
		scrolledComposite_1.setExpandVertical(true);
		
		table = new Table(scrolledComposite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnContent = new TableColumn(table, SWT.NONE);
		tblclmnContent.setWidth(100);
		tblclmnContent.setText("content");
		
		TableItem tableItem_2 = new TableItem(table, SWT.NONE);
		tableItem_2.setText("Pinco");
		
		TableItem tableItem_3 = new TableItem(table, SWT.NONE);
		tableItem_3.setText("Pallino");
		
		TableItem tableItem_4 = new TableItem(table, SWT.NONE);
		tableItem_4.setText("Giorgio");
		scrolledComposite_1.setContent(table);
		scrolledComposite_1.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		sashForm.setWeights(new int[] {1, 1});
		

		
     white = new Color(null, 255, 255, 255);
     image = new Label(this, 0);
     text = new Label(this, 0);

     setBackground(white);
     image.setBackground(white);
     text.setBackground(white);

     addDisposeListener(new DisposeListener() {
         public void widgetDisposed(DisposeEvent e) {
            StackedScrollableTables.this.widgetDisposed(e);
         }
     });
     
     addControlListener(new ControlAdapter() {
         public void controlResized(ControlEvent e) {
            StackedScrollableTables.this.controlResized(e);
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
