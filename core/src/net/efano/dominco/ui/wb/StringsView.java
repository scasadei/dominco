package net.efano.dominco.ui.wb;

import org.eclipse.swt.widgets.TableColumn;

import net.efano.dominco.strings.Strings;
import net.efano.dominco.ui.IDrawable;

public class StringsView implements IDrawable {

	Strings strings;
	TableColumn tableColumn;

	
	public StringsView(TableColumn aTableColumn) {
		tableColumn = aTableColumn;
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
