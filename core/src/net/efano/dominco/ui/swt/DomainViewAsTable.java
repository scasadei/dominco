package net.efano.dominco.ui.swt;

/*
 * A View of a Strings object. It is constructed by means of an SWT Table.
 */

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class DomainViewAsTable implements IViewpage {

	IViewable strings;
	Table table;

	public DomainViewAsTable(Table aTable) {
		table = aTable;
	}

	public DomainViewAsTable(IViewable aStrings, Table aTable) {
		table = aTable;
		// set strings via setStrings to enforce the IDrawable contract
		setViewable(aStrings);
	}
	
	@Override
	public void setViewable(IViewable aStrings) {
		strings = aStrings;
	}

	@Override
	public IViewable getViewable() {
		return strings;
	}

	@Override
	public void drawViewable() {
		strings.draw();
	}

	@Override
	public void readViewable() {
		// TODO Auto-generated method stub

	}

	public void drawString(String aString) {
		TableItem aTableItem = new TableItem(table, SWT.NONE);
		aTableItem.setText(aString);
	}

}
