package application;

import java.awt.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BankAccountController implements Initializable {

	private Player player = Universe.player;

	private Button depositBtn, withdrawBtn, loanBtn, payLoanBtn, exitBtn;
	private Text bankBalance, currLoan, currMoney;
	private TextField depositTextField, withdrawTextField, loanTextField;
	@Override
	
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		bankBalance.setText("Bank Balance: " + player.getAccount().getBalance());
		currLoan.setText("Current Loan: " + player.getAccount().getLoanAmount());
		currMoney.setText("Current Money: " + player.getMoney());
		enforceBalance();
	}
	
	private void enforceBalance() {
		if (player.getAccount().getBalance() <= 0) {
			withdrawBtn.setDisable(true);
		}
		if (player.getMoney() <= 0) {
			depositBtn.setDisable(true);
		}
		if (player.getAccount().hasLoan()) {
			loanBtn.setDisable(true);
			payLoanBtn.setDisable(false);
		} else {
			payLoanBtn.setDisable(true);
			loanBtn.setDisable(false);
		}
	}
	
	private void deposit(ActionEvent event) throws IOException {
		Button clickedBtn = (Button) event.getSource();
		int amt = Integer.parseInt(depositTextField.getText());
		player.getAccount().deposit(amt);
		player.setMoney(player.getMoney() - amt);
        bankBalance.setText("Bank Balance: " + player.getAccount().getBalance());
        currMoney.setText("Current Money: " + player.getMoney());
        enforceBalance();
	}
	
	private void withdraw(ActionEvent event) throws IOException {
	    Button clickedBtn = (Button) event.getSource();
	    int amt = Integer.parseInt(withdrawTextField.getText());
	    player.getAccount().withdraw(amt);
	    player.setMoney(player.getMoney() + amt);
	    bankBalance.setText("Bank Balance: " + player.getAccount().getBalance());
	    currMoney.setText("Current Money: " + player.getMoney());
	    enforceBalance();
	}
}
