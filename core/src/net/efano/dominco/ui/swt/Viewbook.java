package net.efano.dominco.ui.swt;


import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class Viewbook implements IViewpageFactory {

	protected Shell shell;
	private CTabFolder tabFolder;
	private Display display;
	
	public synchronized boolean isReady() {
		return (display!=null && shell!=null && !shell.isDisposed());
	}
	
	public Viewbook() {
		// display = Display.getDefault(); -- this causes an error!
	}
	
	//synchronized public Display getDisplay() {
	//	return display;
	//}
	
	synchronized public void setDisplay() {
		display = Display.getDefault();
	}
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Viewbook window = new Viewbook();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() {
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
	
	public synchronized void  openInOwnThread() {
		Runnable ru = new Runnable() {
			@Override
			public void run() {
				open();
			}
		};
		new Thread(ru).start();
	}

	public void init() {
		setDisplay(); 
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Strings Viewer");
		
		 shell.addListener (SWT.Resize,  new Listener () {
			    public void handleEvent (Event e) {
			      Rectangle rect = shell.getClientArea ();
			      if (tabFolder!=null) {
				  tabFolder.setBounds(0,0,shell.getClientArea().width,shell.getClientArea().height);
			    }
			      System.out.println(rect);
			    }
			  });
		
		 
		tabFolder = new CTabFolder(shell, SWT.BORDER);
		// tabFolder.setBounds(23, 32, 156, 125);
		tabFolder.setBounds(0,0,shell.getSize().x,shell.getSize().y);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));

	    tabFolder.addSelectionListener(new SelectionListener() {
	        public void widgetSelected(SelectionEvent e) {
	          System.out.println("Selected item index = " + tabFolder.getSelectionIndex());
	          System.out.println("Selected item = " + (tabFolder.getSelection() == null ? "null" : tabFolder.getSelection().toString()));
	        }
	        public void widgetDefaultSelected(SelectionEvent e) {
	            widgetSelected(e);
	          }
	    });
	    		
	}
	
	private void addContents() {
		Table table = addView("Nomi","nomi");
		Table table_1 = addView("Citta","citta");
		drawString(table,"Pinco Pallino Mezzolo");
		drawString(table,"Gurdo");
		drawString(table,"Miolo");
		drawString(table_1,"Rapigi");
		drawString(table_1,"Rapigi");
		drawString(table_1,"Rapigi");
		drawString(table_1,"Rapigi");
		drawString(table_1,"Rapigi");
		drawString(table_1,"Megolo");
	}

	@Override
	public Table getNewTable(String viewName,String [] colNames) {
		return addView(viewName,colNames);
	}
	
	private TableItem drawString(Table aTable,String aString) {
		TableItem aTableItem = new TableItem(aTable, SWT.NONE);
		aTableItem.setText(aString);
		return aTableItem;
	}

	private TableItem drawStringRow(Table aTable,String aString []) {
		TableItem aTableItem = new TableItem(aTable, SWT.NONE);
		aTableItem.setText(aString);
		return aTableItem;
	}
	
	private Table addView(String tableName, String columnName) {
		CTabItem tbtmNomi = new CTabItem(tabFolder, SWT.NONE);
		String ttstring = "Not much\n...for now";
		tbtmNomi.setToolTipText ("TabItem toolTip: " + ttstring);
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
	
	private Table addView(String tableName, String columnNames []) {
		CTabItem tbtmNomi = new CTabItem(tabFolder, SWT.NONE);
		String ttstring = "Not much\n...for now";
		tbtmNomi.setToolTipText ("TabItem toolTip: " + ttstring);
		tbtmNomi.setText(tableName);

		ScrolledComposite scrolledComposite = new ScrolledComposite(tabFolder, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tbtmNomi.setControl(scrolledComposite);

		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		Table table = new Table(scrolledComposite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		for (int icol=0; icol<columnNames.length; icol++) {
		TableColumn tblclmnNomi = new TableColumn(table, SWT.NONE);
		tblclmnNomi.setWidth(100);
		tblclmnNomi.setText(columnNames[icol]);
		}
		
		scrolledComposite.setContent(table);
		scrolledComposite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		return table;
		
	}	


	@Override
	public void syncExec(Runnable aRunnable) {
		display.syncExec(aRunnable);
	}	

}
