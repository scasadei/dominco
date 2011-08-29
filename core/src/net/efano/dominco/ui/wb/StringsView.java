package net.efano.dominco.ui.wb;

/*
 * A View of a Strings object. It is constructed by means of an SWT Table.
 */

import org.eclipse.swt.widgets.Table;

import net.efano.dominco.strings.Strings;
import net.efano.dominco.ui.IDrawable;

public class StringsView implements IDrawable {

	Strings strings;
	Table table;

	public StringsView(Table aTable) {
		table = aTable;
	}

	public StringsView(Strings aStrings, Table aTable) {
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

	@Override
	public void drawStrings() {
		// TODO Auto-generated method stub

	}

	@Override
	public void readStrings() {
		// TODO Auto-generated method stub

	}

}
