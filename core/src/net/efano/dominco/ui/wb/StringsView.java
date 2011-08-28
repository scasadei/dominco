package net.efano.dominco.ui.wb;

import org.eclipse.swt.widgets.Table;

import net.efano.dominco.strings.Strings;
import net.efano.dominco.ui.IDrawable;

public class StringsView implements IDrawable {

	Strings strings;
	Table table;

	
	public StringsView(Table aTable) {
		table = aTable;
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
