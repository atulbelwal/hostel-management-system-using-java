public class a_main {

	public static void main(String[] args) {
		
		IDandPasswords idandPasswords = new IDandPasswords();
				
		LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());

	}
}
//main file 