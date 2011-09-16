package net.efano.dominco.ui.widget;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
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

	SashForm sashForm; 
	ScrolledComposite topScroll;
	ScrolledComposite bottomScroll;
	Table bottomTable;
	Table topTable;
	
	public void addContent() {
		
		sashForm = new SashForm(this, SWT.NONE);
		sashForm.setOrientation(SWT.VERTICAL);

		/*
		 * Top component
		 */
		topScroll = new ScrolledComposite(sashForm, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		topScroll.setExpandHorizontal(true);
		topScroll.setExpandVertical(true);

		topTable = new Table(topScroll, SWT.BORDER | SWT.FULL_SELECTION);
		topTable.setHeaderVisible(true);
		topTable.setLinesVisible(true);

		TableColumn tblclmnContext = new TableColumn(topTable, SWT.NONE);
		tblclmnContext.setWidth(100);
		tblclmnContext.setText("context");

		TableItem tableItem = new TableItem(topTable, SWT.NONE);
		tableItem.setText("Date");

		TableItem tableItem_1 = new TableItem(topTable, SWT.NONE);
		tableItem_1.setText("15.09.2011");

		topScroll.setContent(topTable);
		topScroll.setMinSize(topTable.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		/*
		 * Bottom component
		 */
		bottomScroll = new ScrolledComposite(sashForm, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		bottomScroll.setExpandHorizontal(true);
		bottomScroll.setExpandVertical(true);

		bottomTable = new Table(bottomScroll, SWT.BORDER | SWT.FULL_SELECTION);
		bottomTable.setHeaderVisible(true);
		bottomTable.setLinesVisible(true);

		TableColumn tblclmnContent = new TableColumn(bottomTable, SWT.NONE);
		tblclmnContent.setWidth(100);
		tblclmnContent.setText("content");

		TableItem tableItem_2 = new TableItem(bottomTable, SWT.NONE);
		tableItem_2.setText("Pinco");

		TableItem tableItem_3 = new TableItem(bottomTable, SWT.NONE);
		tableItem_3.setText("Pallino");

		TableItem tableItem_4 = new TableItem(bottomTable, SWT.NONE);
		tableItem_4.setText("Giorgio");
		bottomScroll.setContent(bottomTable);
		bottomScroll.setMinSize(bottomTable.computeSize(SWT.DEFAULT, SWT.DEFAULT));


		sashForm.setWeights(new int[] {1, 1});
		
	}
	
	public void addExtraContent() {
		white = new Color(null, 255, 255, 255);
		image = new Label(this, 0);
		text = new Label(this, 0);

		setBackground(white);
		image.setBackground(white);
		text.setBackground(white);
		text.setText("ciccio");

		
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
	
	StackedScrollableTables(Composite parent, int style) {
		super(parent, style);
		
		text = new Label(this,0);
		text.setText("blah");

		image = new Label(this, 0);

		addControlListener(new ControlAdapter() {
			public void controlResized(ControlEvent e) {
				StackedScrollableTables.this.controlResized(e);
			}
		});

		addContent();

	}
	// end of main construction


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
		sashForm.setBounds(0,0,getSize().x,getSize().y);
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
		// return new Point(100,200);
		// return new Point(wHint,hHint);
		
		Point iExtent = image.computeSize(SWT.DEFAULT, SWT.DEFAULT, false);
		Point tExtent = text.computeSize(SWT.DEFAULT, SWT.DEFAULT, false);
		int width = iExtent.x + 5 + tExtent.x;
		int height = Math.max(iExtent.y, tExtent.y);
		if (wHint != SWT.DEFAULT) width = wHint;
		if (hHint != SWT.DEFAULT) height = hHint;         
		return new Point(width + 2, height + 2);
		
	}

}
