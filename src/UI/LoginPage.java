package team08UI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class LoginPage {

	protected Shell shell;
	private Text usernameInput;
	private Text passwordInput;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LoginPage window = new LoginPage();
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
		shell.setToolTipText("Username");
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		usernameInput = new Text(shell, SWT.BORDER);
		usernameInput.setBounds(142, 96, 150, 21);
		usernameInput.setToolTipText("Username");
		
		Label lblLogin = new Label(shell, SWT.NONE);
		lblLogin.setBounds(193, 10, 62, 34);
		lblLogin.setFont(SWTResourceManager.getFont("Calibri", 14, SWT.BOLD));
		lblLogin.setText("Login");
		
		Label lblUsername = new Label(shell, SWT.NONE);
		lblUsername.setBounds(142, 75, 150, 15);
		lblUsername.setFont(SWTResourceManager.getFont("Candara", 9, SWT.NORMAL));
		lblUsername.setText("Username");
		
		Label lblPassword = new Label(shell, SWT.NONE);
		lblPassword.setBounds(142, 123, 150, 15);
		lblPassword.setFont(SWTResourceManager.getFont("Candara", 9, SWT.NORMAL));
		lblPassword.setText("Password");
		
		passwordInput = new Text(shell, SWT.PASSWORD| SWT.BORDER);
		passwordInput.setBounds(142, 144, 150, 21);
		passwordInput.setToolTipText("Username");
		
		Button btnLogin = new Button(shell, SWT.NONE);
		btnLogin.setBounds(142, 171, 75, 25);
		btnLogin.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				HomePage hP = new HomePage();
				hP.open();
			}
		});
		btnLogin.setFont(SWTResourceManager.getFont("Candara", 9, SWT.NORMAL));
		btnLogin.setText("Login");
		
		Button btnRegister = new Button(shell, SWT.NONE);
		btnRegister.setBounds(217, 171, 75, 25);
		btnRegister.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				RegisterPage rP = new RegisterPage();
				rP.open();
			}
		});
		btnRegister.setFont(SWTResourceManager.getFont("Candara", 9, SWT.NORMAL));
		btnRegister.setText("Register");

	}

}
