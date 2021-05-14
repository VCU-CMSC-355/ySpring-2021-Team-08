package team08UI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class TaxPage {

	protected Shell shell;
	private Text incomeInput;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TaxPage window = new TaxPage();
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
		shell.setLayout(null);
		
		Combo tYear = new Combo(shell, SWT.NONE);
		tYear.setBounds(110, 50, 91, 23);
		tYear.add("2020");
		tYear.add("2021");
		
		Label sTxClc = new Label(shell, SWT.NONE);
		sTxClc.setBounds(10, 10, 122, 23);
		sTxClc.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.NORMAL));
		sTxClc.setText("Tax Calculator");
		
		Label sTxYr = new Label(shell, SWT.NONE);
		sTxYr.setBounds(45, 50, 54, 19);
		sTxYr.setFont(SWTResourceManager.getFont("Calibri", 10, SWT.NORMAL));
		sTxYr.setText("Tax Year");
		
		Label seperator = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		seperator.setBounds(216, 70, 2, 64);
		
		Label sType = new Label(shell, SWT.NONE);
		sType.setBounds(45, 100, 30, 19);
		sType.setFont(SWTResourceManager.getFont("Calibri", 10, SWT.NORMAL));
		sType.setText("Type");
		
		Combo tType = new Combo(shell, SWT.NONE);
		tType.setBounds(110, 100, 91, 23);
		tType.add("Single");
		tType.add("Joint");
		tType.add("Head of Household");
		
		Label sGrsIcm = new Label(shell, SWT.NONE);
		sGrsIcm.setBounds(45, 150, 83, 19);
		sGrsIcm.setFont(SWTResourceManager.getFont("Calibri", 9, SWT.NORMAL));
		sGrsIcm.setText("Gross Income");
		
		incomeInput = new Text(shell, SWT.BORDER);
		incomeInput.setBounds(134, 150, 67, 21);
		
		Label sEstTx = new Label(shell, SWT.NONE);
		sEstTx.setBounds(250, 50, 122, 19);
		sEstTx.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.NORMAL));
		sEstTx.setText("Estimated Taxes");
		
		Label lblTesting = new Label(shell, SWT.NONE);
		lblTesting.setBounds(289, 97, 54, 23);
		lblTesting.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.NORMAL));
		lblTesting.setVisible(false);
		lblTesting.setText("Testing");
		
		Button Calculate = new Button(shell, SWT.NONE);
		Calculate.setBounds(45, 190, 75, 25);
		Calculate.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				lblTesting.setVisible(true);
			}
		});
		Calculate.setText("Calculate");
		
		Button Home = new Button(shell, SWT.NONE);
		Home.setBounds(349, 226, 75, 25);
		Home.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				HomePage hP = new HomePage();
				hP.open();
			}
		});
		Home.setFont(SWTResourceManager.getFont("Candara", 9, SWT.NORMAL));
		Home.setText("Home");
		
		
	}
}
