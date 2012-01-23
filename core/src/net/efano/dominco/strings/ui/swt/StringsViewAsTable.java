package net.efano.dominco.strings.ui.swt;

/*
 * A View of a Strings object. It is constructed by means of an SWT Table.
 */

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import net.efano.dominco.strings.Strings;
import net.efano.dominco.strings.ui.IStringsViewpage;

public class StringsViewAsTable implements IStringsViewpage {

	Strings strings;
	Table table;

	public StringsViewAsTable(Table aTable) {
		table = aTable;
	}

	public StringsViewAsTable(Strings aStrings, Table aTable) {
		table = aTable;
		// set strings via setStrings to enforce the IDrawable contract
		setStrings(aStrings);
	}
	
	@Override
	public void setStrings(Strings aStrings) {
		strings = aStrings;
	}

	@Override
	public Strings getStrings() {
		return strings;
	}

	public void drawStrings2() {
	table.getDisplay().asyncExec(new Runnable() {
		public void run () {
			strings.getView().drawStrings();
		}
	});
	}
	
	@Override
	public void drawStrings() {
		strings.draw();
	}

	@Override
	public void readStrings() {
		// TODO Auto-generated method stub

	}

	public void drawString(String aString) {
		TableItem aTableItem = new TableItem(table, SWT.NONE);
		aTableItem.setText(aString);
	}

}
