package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.org.apache.xerces.internal.dom.DeferredProcessingInstructionImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BankAccountController implements Initializable {

	private Player player = Universe.player;

	private Button deposit, withdraw, loan, payLoan, exit;
	private Text bankBalance, currLoan, currMoney;
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
			withdraw.setDisable(true);
		}
		if (player.getMoney() <= 0) {
			deposit.setDisable(true);
		}
		if (player.getAccount().hasLoan()) {
			loan.setDisable(true);
			payLoan.setDisable(false);
		} else {
			payLoan.setDisable(true);
			loan.setDisable(false);
		}
	}
	
	private void deposit(ActionEvent event) throws IOException {
		Button clickedBtn = (Button) event.getSource();
		double amt = depositTF.getText();
	}
}
