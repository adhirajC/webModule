package webModule;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/*import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
*/
@Entity
public class AccountModel {

	@Id
	@GeneratedValue
	private int accountID;
	
	
	private String accountType;
	
	private double amount;
	
	@OneToOne
	private UserModel owner;
	
	public AccountModel() {
	}
	public AccountModel(UserModel owner, int accountID, String accountType, double amount) {
		this.owner=owner;
		this.accountID=accountID;
		this.accountType=accountType;
		this.amount=amount;
	}
	
	public int getAccountID() {
		return accountID;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getAmount() {
		return amount;
	}
	
	
	
	
}
