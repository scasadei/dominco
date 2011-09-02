package net.efano.dominco.ui.swt;

/*
 * A View of a Strings object. It is constructed by means of an SWT Table.
 */


import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import net.efano.dominco.DomainContext;
import net.efano.dominco.strings.Strings;

public class DomainContextView implements IViewpage {

	DomainContext domainContext;
	Table table;

	public DomainContextView(Table aTable) {
		table = aTable;
	}

	public DomainContextView(DomainContext aDomainContext, Table aTable) {
		table = aTable;
		// set strings via setStrings to enforce the IViewable contract
		setViewable(aDomainContext);
	}
	
	@Override
	public void setViewable(IViewable aDomainContext) {
		domainContext = (DomainContext) aDomainContext;
	}

	@Override
	public IViewable getViewable() {
		return domainContext;
	}

	@Override
	public void drawViewable() {
		domainContext.draw();
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
