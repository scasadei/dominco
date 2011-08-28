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
	private Table table;
	private Table table_1;
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
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		tabFolder = new CTabFolder(shell, SWT.BORDER);
		tabFolder.setBounds(23, 32, 156, 125);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		CTabItem tbtmNomi = new CTabItem(tabFolder, SWT.NONE);
		tbtmNomi.setText("Nomi");
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(tabFolder, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tbtmNomi.setControl(scrolledComposite);
		
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		table = new Table(scrolledComposite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNomi = new TableColumn(table, SWT.NONE);
		tblclmnNomi.setWidth(100);
		tblclmnNomi.setText("nomi");
		
		TableItem tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText("Pinco Pallino");
		
		TableItem tableItem_1 = new TableItem(table, SWT.NONE);
		tableItem_1.setText("Carlotto Spanzani");
		
		TableItem tableItem_2 = new TableItem(table, SWT.NONE);
		tableItem_2.setText("Giulio Cesarotti");
		scrolledComposite.setContent(table);
		scrolledComposite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		CTabItem tbtmCitta = new CTabItem(tabFolder, SWT.NONE);
		tbtmCitta.setText("Citta");
		
		ScrolledComposite scrolledComposite_2 = new ScrolledComposite(tabFolder, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tbtmCitta.setControl(scrolledComposite_2);
		scrolledComposite_2.setExpandHorizontal(true);
		scrolledComposite_2.setExpandVertical(true);
		
		table_1 = new Table(scrolledComposite_2, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		TableColumn tblclmnCitta = new TableColumn(table_1, SWT.NONE);
		tblclmnCitta.setWidth(100);
		tblclmnCitta.setText("citta");
		
		TableItem tableItem_3 = new TableItem(table_1, SWT.NONE);
		tableItem_3.setText("Rapigi");
		
		TableItem tableItem_4 = new TableItem(table_1, SWT.NONE);
		tableItem_4.setText("Secena");
		
		TableItem tableItem_5 = new TableItem(table_1, SWT.NONE);
		tableItem_5.setText("Rifenze");
		
		TableItem tableItem_6 = new TableItem(table_1, SWT.NONE);
		tableItem_6.setText("Lobogna");
		scrolledComposite_2.setContent(table_1);
		scrolledComposite_2.setMinSize(table_1.computeSize(SWT.DEFAULT, SWT.DEFAULT));

	}

	@Override
	public IDrawable getNewDrawable() {
		return new StringsView(addColumnView("StringsView","Strings'"));
	}

	private TableItem drawString(Table aTable,String aString) {
		TableItem aTableItem = new TableItem(aTable, SWT.NONE);
		aTableItem.setText(aString);
		return aTableItem;
	}
	
	private TableColumn addColumnView(String tableName, String columnName) {
		CTabItem tbtmNomi = new CTabItem(tabFolder, SWT.NONE);
		tbtmNomi.setText(tableName);

		ScrolledComposite scrolledComposite = new ScrolledComposite(tabFolder, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tbtmNomi.setControl(scrolledComposite);

		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		table = new Table(scrolledComposite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tblclmnNomi = new TableColumn(table, SWT.NONE);
		tblclmnNomi.setWidth(100);
		tblclmnNomi.setText(columnName);
		return tblclmnNomi;
	}	
}
