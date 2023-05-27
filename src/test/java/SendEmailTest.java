import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.ResponseBody;

public class SendEmailTest {
	@Autowired
	public JavaMailSender emailSender;
	@ResponseBody
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo("duc50611@gmail.com");
	        message.setSubject("HOT NEW");
	        message.setText("Chúng tôi mới bán thêm một sản phẩm mới tên là . nhấn vào đây để biết thêm thông tin chi tiết");
	        System.out.print("gui roi");
	        
	}

}
