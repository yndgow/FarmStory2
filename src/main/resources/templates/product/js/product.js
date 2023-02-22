/**
 * 
 */
$(() => {
	
	//수량 증가 버튼
	$('.increase , .decrease ').click(function(){
		amountBtn($(this).attr('class'));
	});
	
	//장바구니, 구매하기 버튼 이벤트
	$('.cart, .order').click(function(){
		if(loginCheck()){
			let bntClassName = $(this).attr('class');
			if (bntClassName == 'cart'){
				//장바구니 클릭 시
				let jsonData= {
					uid: $('.sessUser_uid').text(),
					prodNo : $('input[name=prodNo]').val(),
					count : $('input[name=num]').val(),
					price : $('input[name=ori-price]').val(),
					discount : $('input[name=discount]').val(),
					delivery : $('input[name=delivery]').val(),
				};
				$.ajax({
					type: 'post',
					url: '/Kmarket/product/view',
					data: jsonData,
					dataType: 'json',
					success: function(data){
						if(data.result > 0 && confirm('장바구니에 담겼습니다. 이동?')){
							location.href = '/Kmarket2/product/cart.html?uid='+$('.sessUser_uid').text();
						}					
					}
				});
			}else if (btnClassName == 'order'){
				// 구매하기 클릭시
				let uid = $('.sessUser_uid').text();
				let prodNo = $('input[name=prodNo]').val();
				let price = Number($('input[name=ori-orice]').val());
				let count = $('input[name=num]').val();
				let discount = Number($('input[name=discount]').val());
				let discointPrice = Math.floor((price*discount) / 100);
				let delivery = Number($('input[name=delivery]').val());
				let point = Math.ceil(((price * (100 - discount)) / 100) * count * 0.01);
				let total = Math.ceil(((price * (100 - discount)) / 100) * count)+ delivery;
				let jsonData = {
					uid:uid,
					prodNo:prodNo,
					cartCount:count,
					cartPrice:price,
					cartDiscount:discount,
					cartDelivery:delivery,
					cartPoint:point,
					cartTotal:total
				};
				$.ajax({
					type:'post',
					url: '/Kmarket2/product/cart',
					data:jsonData,
					dataType: 'json',
					success: function(data){
						if(data.result > 0){
							location.href = '/Kmarket2/product/order.html?uid=${uid}&prodNo=${prodNo}&count=${count}';
						}
					}
				});
			}
		} 
	});
	


	
})


//////////
//함수모음//
//////////

// 로그인 체크, 장바구니, 구매하기
function loginCheck(){
	let session = $('.sessUser_uid').text();
	if(session == ''){
		if (confirm('로그인 먼저 하십쇼. 로그인 페이지로 이동?')){
			location.href = '/Kmarket2/member/login';
		}
		return false;
	} else{
		return true;
	}
}

// 수량 증가 버튼
function amountBtn(BtnClassName){
	let num = $('input[name=num]').val();
	num = Number(num);
	if(BtnClassName == 'increase'){
		if (num < 100) num += 1;
	} else{
		if (num > 1) num -= 1;
	}
	
	
}












