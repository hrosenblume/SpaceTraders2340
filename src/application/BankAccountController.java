package application;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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

	@FXML
	private Button depositBtn, withdrawBtn, loanBtn, payLoanBtn, exitBtn;
	
	@FXML
	private Label bankBalance, currLoan, currMoney;
	
	@FXML
	private TextField depositTextField, withdrawTextField, loanTextField;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		bankBalance.setText("Bank Balance: " + player.getAccount().getBalance());
		currLoan.setText("Current Loan: " + player.getAccount().getLoanAmount());
		currMoney.setText("Current Money: " + player.getMoney());
		enforceBalance();
	}
	
	@FXML
	private void enforceBalance() {
		if (player.getAccount().getBalance() <= 0) {
			withdrawBtn.setDisable(true);
		} else {
			withdrawBtn.setDisable(false);
		}
		if (player.getMoney() <= 0) {
			depositBtn.setDisable(true);
		} else {
			depositBtn.setDisable(false);
		}
		if (player.getAccount().hasLoan()) {
			loanBtn.setDisable(true);
			payLoanBtn.setDisable(false);
		} else {
			payLoanBtn.setDisable(true);
			loanBtn.setDisable(false);
		}
	}
	
	@FXML
	private void deposit(ActionEvent event) throws IOException {
		Button clickedBtn = (Button) event.getSource();
		int amt = Integer.parseInt(depositTextField.getText());
		player.getAccount().deposit(amt);
		player.setMoney(player.getMoney() - amt);
        bankBalance.setText("Bank Balance: " + player.getAccount().getBalance());
        currMoney.setText("Current Money: " + player.getMoney());
        enforceBalance();
	}
	
	@FXML
	private void withdraw(ActionEvent event) throws IOException {
	    Button clickedBtn = (Button) event.getSource();
	    int amt = Integer.parseInt(withdrawTextField.getText());
	    player.getAccount().withdraw(amt);
	    player.setMoney(player.getMoney() + amt);
	    bankBalance.setText("Bank Balance: " + player.getAccount().getBalance());
	    currMoney.setText("Current Money: " + player.getMoney());
	    enforceBalance();
	}
	
	@FXML
	private void getLoan(ActionEvent event) throws IOException {
	    Button clickedBtn = (Button) event.getSource();
	    int amt = Integer.parseInt(loanTextField.getText());
	    player.getAccount().loan(amt);
	    int interest = player.getAccount().chargeInterest(amt);
	    currLoan.setText("Current Loan: " + player.getAccount().getLoanAmount());
	    bankBalance.setText("Bank Balance: " + player.getAccount().getBalance());
	    enforceBalance();
	}
	
	@FXML
	private void payLoan (ActionEvent event) throws IOException {
	    Button clickedBtn = (Button) event.getSource();
	    player.getAccount().payloan();
       currLoan.setText("Current Loan: " + player.getAccount().getLoanAmount());
        bankBalance.setText("Bank Balance: " + player.getAccount().getBalance());
        enforceBalance();
	}
	
	@FXML
	private void quit(ActionEvent event) throws IOException {
		Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
	}
}
