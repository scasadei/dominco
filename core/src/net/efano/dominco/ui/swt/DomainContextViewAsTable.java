package net.efano.dominco.ui.swt;

/*
 * A View of a Viewable object. It is constructed by means of an SWT Table.
 */

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import net.efano.dominco.DomainContext;
import net.efano.dominco.ui.IViewable;
import net.efano.dominco.ui.IViewpage;

public class DomainContextViewAsTable implements IViewpage {

	DomainContext dc;
	Table table;

	public DomainContextViewAsTable(Table aTable) {
		table = aTable;
	}

	public DomainContextViewAsTable(DomainContext aDomainContext, Table aTable) {
		table = aTable;
		// set strings via setStrings to enforce the IDrawable contract
		setViewable(aDomainContext);
	}
	
	@Override
	public void setViewable(IViewable aDomainContext) {
		dc = (DomainContext)aDomainContext;
	}

	@Override
	public IViewable getViewable() {
		return dc;
	}

	@Override
	public void drawViewable() {
		dc.draw();
	}

	@Override
	public void readViewable() {
		// TODO Auto-generated method stub

	}

	public void drawOneRow(String aString) {
		TableItem aTableItem = new TableItem(table, SWT.NONE);
		aTableItem.setText(aString);
	}

}
