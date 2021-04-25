package team08UI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class SettingsPage {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SettingsPage window = new SettingsPage();
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
		
		Label lblSettings = new Label(shell, SWT.NONE);
		lblSettings.setFont(SWTResourceManager.getFont("Calibri", 16, SWT.NORMAL));
		lblSettings.setBounds(10, 10, 67, 26);
		lblSettings.setText("Settings");
		
		Label lblTranslatorLanguage = new Label(shell, SWT.NONE);
		lblTranslatorLanguage.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.NORMAL));
		lblTranslatorLanguage.setBounds(20, 42, 132, 19);
		lblTranslatorLanguage.setText("Translator Language");
		
		Label lblLanguageCg = new Label(shell, SWT.NONE);
		lblLanguageCg.setVisible(false);
		lblLanguageCg.setBounds(273, 67, 115, 15);
		lblLanguageCg.setText("Language changed");
		
		Button btnSpanish = new Button(shell, SWT.NONE);
		btnSpanish.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				lblLanguageCg.setVisible(true);
				
			}
		});
		btnSpanish.setFont(SWTResourceManager.getFont("Candara", 9, SWT.NORMAL));
		btnSpanish.setBounds(30, 67, 75, 25);
		btnSpanish.setText("Spanish");
		
		Button btnFrench = new Button(shell, SWT.NONE);
		btnFrench.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				lblLanguageCg.setVisible(true);
			}
		});
		btnFrench.setFont(SWTResourceManager.getFont("Candara", 9, SWT.NORMAL));
		btnFrench.setBounds(111, 67, 75, 25);
		btnFrench.setText("French");
		
		Button btnGerman = new Button(shell, SWT.NONE);
		btnGerman.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				lblLanguageCg.setVisible(true);
			}
		});
		btnGerman.setFont(SWTResourceManager.getFont("Candara", 9, SWT.NORMAL));
		btnGerman.setBounds(192, 67, 75, 25);
		btnGerman.setText("German");
		
		Label lblPasswordReset = new Label(shell, SWT.NONE);
		lblPasswordReset.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.NORMAL));
		lblPasswordReset.setBounds(20, 98, 103, 19);
		lblPasswordReset.setText("Password Reset");
		
		Label lblOldPassword = new Label(shell, SWT.NONE);
		lblOldPassword.setBounds(30, 123, 75, 15);
		lblOldPassword.setText("Old Password");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(30, 144, 125, 21);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(161, 144, 125, 21);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(292, 144, 125, 21);
		
		Label lblNewPassword = new Label(shell, SWT.NONE);
		lblNewPassword.setBounds(161, 123, 77, 15);
		lblNewPassword.setText("New Password");
		
		Label lblConfirmNewPassword = new Label(shell, SWT.NONE);
		lblConfirmNewPassword.setBounds(292, 123, 124, 15);
		lblConfirmNewPassword.setText("Confirm New Password");
		
		Button btnChangePassword = new Button(shell, SWT.NONE);
		btnChangePassword.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Label lblPasswordChanged = new Label(shell, SWT.NONE);
				lblPasswordChanged.setBounds(30, 202, 106, 15);
				lblPasswordChanged.setText("Password Changed!");
			}
		});
		btnChangePassword.setBounds(30, 171, 106, 25);
		btnChangePassword.setText("Change Password");
		
		Button btnHome = new Button(shell, SWT.NONE);
		btnHome.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				HomePage hP = new HomePage();
				hP.open();
			}
		});
		btnHome.setBounds(349, 226, 75, 25);
		btnHome.setText("Home");
		

		

	}
}
