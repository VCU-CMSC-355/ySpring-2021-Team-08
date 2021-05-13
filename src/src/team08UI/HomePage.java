package team08UI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;


import org.eclipse.swt.widgets.Label;

public class HomePage {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			HomePage window = new HomePage();
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
		shell.setSize(500, 350);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		Button btnCredits = new Button(shell, SWT.NONE);
		btnCredits.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				Credits cP = new Credits();
				cP.open();
			}
		});
		btnCredits.setFont(SWTResourceManager.getFont("Candara", 9, SWT.NORMAL));
		btnCredits.setBounds(399, 276, 75, 25);
		btnCredits.setToolTipText("Where it is due!");
		btnCredits.setText("Credits");
		
		Button btnSettings = new Button(shell, SWT.NONE);
		btnSettings.setFont(SWTResourceManager.getFont("Candara", 9, SWT.NORMAL));
		btnSettings.setBounds(399, 245, 75, 25);
		btnSettings.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				SettingsPage sP = new SettingsPage();
				sP.open();
			}
		});
		btnSettings.setToolTipText("Settings Page");
		btnSettings.setText("Settings");
		
		Button btnTranslator = new Button(shell, SWT.NONE);
		btnTranslator.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				Translator tP = new Translator();
				tP.open();
			}
		});
		btnTranslator.setFont(SWTResourceManager.getFont("Candara", 9, SWT.NORMAL));
		btnTranslator.setBounds(100, 100, 125, 100);
		btnTranslator.setText("Translator");
		
		Button btnTaxCalculator = new Button(shell, SWT.NONE);
		btnTaxCalculator.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				TaxPage txP = new TaxPage();
				txP.open();
			}
		});
		btnTaxCalculator.setFont(SWTResourceManager.getFont("Candara", 9, SWT.NORMAL));
		btnTaxCalculator.setBounds(275, 100, 125, 100);
		btnTaxCalculator.setText("Tax Calculator");
		
		Label lblHome = new Label(shell, SWT.NONE);
		lblHome.setFont(SWTResourceManager.getFont("Calibri", 16, SWT.NORMAL));
		lblHome.setBounds(10, 10, 99, 52);
		lblHome.setText("Home");
		



	}
	
	static String getData(String command) {
		String out = "";
		try {
		String utilityPath = new File("modules/serviceBroker.jar").getAbsolutePath();
		System.out.println(utilityPath);
		String utilityModule = "java -jar \"" + utilityPath + "\" " + command;
		System.out.println(utilityModule);
		Process p = Runtime.getRuntime().exec("java -jar /modules/serviceBroker.jar");
		BufferedReader moduleOutput = new BufferedReader(new InputStreamReader(p.getInputStream()));

		out = moduleOutput.readLine();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		return out;
	}
}
