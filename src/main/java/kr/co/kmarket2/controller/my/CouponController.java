package kr.co.kmarket2.controller.my;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CouponController {

	@GetMapping("my/coupon")
	public String coupon() {
		return "my/coupon";
	}
}
