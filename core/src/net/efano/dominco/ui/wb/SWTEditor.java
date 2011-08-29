package net.efano.dominco.ui.wb;

import net.efano.dominco.ui.IDrawable;
import net.efano.dominco.ui.IEditor;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
// import net.efano.dominco.ui.wb.StringsView;;

public class SWTEditor implements IEditor {

	protected Shell shell;
	// private Table table;
	// private Table table_1;
	private CTabFolder tabFolder;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SWTEditor window = new SWTEditor();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		init();
		addContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	
	protected void init() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Strings Viewer");
		
		tabFolder = new CTabFolder(shell, SWT.BORDER);
		tabFolder.setBounds(23, 32, 156, 125);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));

	}
	
	protected void addContents() {
		Table table = addView("Nomi","nomi");
		drawString(table,"Pinco Pallino Mezzolo");
		drawString(table,"Gurdo");
		drawString(table,"Miolo");
		
		

		Table table_1 = addView("Citta","citta");
		drawString(table_1,"Rapigi");
		drawString(table_1,"Rapigi");
		drawString(table_1,"Rapigi");
		drawString(table_1,"Rapigi");
		drawString(table_1,"Rapigi");
		drawString(table_1,"Megolo");

	}

	@Override
	public IDrawable getNewDrawable() {
		return new StringsView(addView("StringsView","Strings'"));
	}

	private TableItem drawString(Table aTable,String aString) {
		TableItem aTableItem = new TableItem(aTable, SWT.NONE);
		aTableItem.setText(aString);
		return aTableItem;
	}
	
	private Table addView(String tableName, String columnName) {
		CTabItem tbtmNomi = new CTabItem(tabFolder, SWT.NONE);
		tbtmNomi.setText(tableName);

		ScrolledComposite scrolledComposite = new ScrolledComposite(tabFolder, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tbtmNomi.setControl(scrolledComposite);

		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		Table table = new Table(scrolledComposite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tblclmnNomi = new TableColumn(table, SWT.NONE);
		tblclmnNomi.setWidth(100);
		tblclmnNomi.setText(columnName);
		
		scrolledComposite.setContent(table);
		scrolledComposite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		
		return table;
	}	
}
