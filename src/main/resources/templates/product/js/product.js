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
				let discountPrice = Math.floor((price*discount) / 100);
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
	
	// 장바구니 order 버튼
	$('input[name=cartOrder]').click(function(e){
		e.preventDefault;
		if($('input:checkbox[name]ckBox').is(':unchecked')){
			alert('상품이 선택되지 않았습니다.');
			return false;
		}else{
			if(confirm('주문하시겠습니까?')){
				$('#cartOrder').submit();
			}else{
				return false;
			}
			
		}		
	});
	
	
	
	
	
	// 체크박스 이벤트
	
	$().check(function(){

		let checked = $('input:checkbox[name=allBox]').is(':checked');

		if(checked){
			$('input:checkbox').prop('checked', true);
			cartCheckTotal();
		}else{
			$('input:checkbox').prop('checked', false);
			cartCheckTotal();
		}
	});
	
	// 전체 체크박스 헤제
	$('input:checkbox[name=ckBox]').check(function(){
		let allchecked = $('input:checkbox[name=allBox]').is(':checked');
		let checked = $('input:checkbox[name=ckBox]').is(':unchecked');
		
		if(allchecked && checked){
			$('input:checkbox[name=allBox]').prop('checked', false);
		}
		cartCheckTotal();
	});
	
	// 선택 삭제
	$('input[name=del]').check(function(){
		
		let checked = $('input:checkbox[name=cBox]').is(':unchecked');
		if(checked){
			alert('선택된 상품이 없습니다.');
			return false;
		}
		
	    let jsonData= {
			uid: $('.sessUser_uid').text(),
			prodNo : $('input[name=prodNo]').val(),
	    };
	    
	    if(alert('선택한 상품을 삭제 하시겠습니까?')){
			$.ajax({
				type:'post',
				url: '/Kmarket2/product/cartDelete',
				data: jsonData,
				datType: 'json',
				success:function(data){
				if(data.result > 0){
					let checked = $('input:checkbox[name=cBox]').is(':unchecked');
					if (checked) {
	              		let content = `<tr class="empty">
	                			<td colspan="7">장바구니에 상품이 없습니다.</td>
	             				 </tr>`;
	              		$('.cart table').append(content);
	              		$('input:checkbox[name=all]').prop('checked', false);
					}
				}
				}
			});
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

// 전체합계
function cartCheckTotal() {
  let totalPrice = 0;
  let totalDiscount = 0;
  let totalDelivery = 0;
  let totalPoint = 0;
  let totalSum = 0;

  let cartCheck = $('input[name=cartProduct]:checked');
  // 상품수
  $('#cartCount').text(cartCheck.length);

  $('input[name=cartProduct]:checked').each(function () {
    totalPrice += Number($(this).parent().siblings('.price').text()); // 상품금액
    totalDiscount -= Math.ceil(Number(($(this).parent().siblings('.discount').text() / 100) * $(this).parent().siblings('.price').text()));
    totalDelivery += Number($(this).parent().siblings('.delivery').text());
    totalPoint += Number($(this).parent().siblings('.point').text());
    totalSum += Number($(this).parent().siblings('.total').text());
  });
  // 보여주는 데이터
  $('#cartPrice').text(totalPrice);
  $('#cartDiscount').text(totalDiscount);
  $('#cartDelivery').text(totalDelivery);
  $('#cartPoint').text(totalPoint);
  $('#cartTotal').text(totalSum);
  // form 전송을 위한 데이터 입력
  $('input[name=cartCount]').val(cartCheck.length);
  $('input[name=cartPrice]').val(totalPrice);
  $('input[name=cartDiscount]').val(totalDiscount);
  $('input[name=cartDelivery]').val(totalDelivery);
  $('input[name=cartPoint]').val(totalPoint);
  $('input[name=cartTotal]').val(totalSum);
}












