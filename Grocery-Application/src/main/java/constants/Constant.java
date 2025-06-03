package constants;

public class Constant {

	public static final String excelFileForLogin = System.getProperty("user.dir")
			+ " \\src\\test\\resources\\TestData\\excelReadLogin.xlsx";
	public static final String imageFile = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\Images\\download.jpeg";
	public static final String configFile = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\Config.properties";
	public static final String category_success_alert = "Test failed: Success message is not displayed.";
	public static final String category_not_found = "Test failed: Category not found in search results.";
	public static final String search_area_not_reset = "Test failed: Search area was not reset or still visible.";
	public static final String category_edit_success = "Test failed: Success message is not displayed after editing the category.";
	public static final String status_toggle_failed = "Test failed: Status badge did not toggle correctly between Active and Inactive.";
	public static final String delete_success_alert = "Test failed: Category was not deleted successfully.";
	public static final String lp_verify_login_with_valid_data = "Login failed with valid credentials.";
	public static final String lp_invalid_username = "Login successful for invalid username.";
	public static final String lp_invalid_password = "Login successful for invalid password.";
	public static final String lp_invalid_username_password = "Login successful for invalid username and password.";
	public static final String mc_edit_success_alert = "Test failed: Success message is not displayed after editing the contact.";
	public static final String mc_contact_title_displayed = "Test failed: Contact form is not resetted.";
	public static final String news_info_not_entered = "Test Failed: News information not entered";
	public static final String news_info_not_updated = "Test Failed: News information not updated";
	public static final String news_info_not_deleted = "Test Failed: News information not deleted";

}
