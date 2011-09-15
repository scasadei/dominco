package net.efano.dominco.ui.wb;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class StackedScrolledTables extends Composite {
	private Table table;
	private Table table_1;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public StackedScrolledTables(Composite parent, int style) {
		super(parent, style);
		
		SashForm sashForm_2 = new SashForm(this, SWT.NONE);
		sashForm_2.setBounds(111, 31, 180, 234);
		
		SashForm sashForm = new SashForm(sashForm_2, SWT.NONE);
		sashForm.setOrientation(SWT.VERTICAL);
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(sashForm, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		ScrolledComposite scrolledComposite_2 = new ScrolledComposite(scrolledComposite, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
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
		scrolledComposite.setContent(scrolledComposite_2);
		scrolledComposite.setMinSize(scrolledComposite_2.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
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
		
		SashForm sashForm_1 = new SashForm(sashForm_2, SWT.NONE);
		sashForm_1.setOrientation(SWT.VERTICAL);
		
		ScrolledComposite scrolledComposite_3 = new ScrolledComposite(sashForm_1, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite_3.setExpandHorizontal(true);
		scrolledComposite_3.setExpandVertical(true);
		
		ScrolledComposite scrolledComposite_4 = new ScrolledComposite(sashForm_1, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite_4.setExpandHorizontal(true);
		scrolledComposite_4.setExpandVertical(true);
		sashForm_1.setWeights(new int[] {1, 1});
		
		SashForm sashForm_3 = new SashForm(sashForm_2, SWT.NONE);
		sashForm_3.setOrientation(SWT.VERTICAL);
		
		ScrolledComposite scrolledComposite_5 = new ScrolledComposite(sashForm_3, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite_5.setExpandHorizontal(true);
		scrolledComposite_5.setExpandVertical(true);
		
		ScrolledComposite scrolledComposite_6 = new ScrolledComposite(sashForm_3, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite_6.setExpandHorizontal(true);
		scrolledComposite_6.setExpandVertical(true);
		sashForm_3.setWeights(new int[] {1, 1});
		sashForm_2.setWeights(new int[] {1, 1, 1});

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
