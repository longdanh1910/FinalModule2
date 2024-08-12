import controller.BankAccountController;
import model.BankAccountManager;
import view.BankAccountView;

public class Main {
    public static void main(String[] args) {
        BankAccountManager manager = new BankAccountManager();
        BankAccountView view = new BankAccountView();
        BankAccountController controller = new BankAccountController(manager, view);
        controller.start();
    }
}
