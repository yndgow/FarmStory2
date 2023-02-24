document.addEventListener('DOMContentLoaded',()=>{
	// 장바구니 클릭
			$('.cart').click(function(){
				
				//let uid = $('span[name=uid]').text();
				let uid = "admin";
				let prodNo = $('input[name=prodNo]').val();
				let count = $('input[name=num]').val();
				let price = $('input[name=price]').val();
				let discount = $('input[name=discount]').val();
				let point = $('input[name=point]').val();
				let delivery = $('input[name=delivery]').val();
				let total = $('.total > span').text().replaceAll(',','');
				console.log(uid);
				
				let jsonData = {
						"uid": uid,
						"prodNo": prodNo,
						"count": count,
						"price": price,
						"discount": discount,
						"point": point,
						"delivery": delivery,
						"total": total,
				};
				console.log(jsonData);
				if(uid){
					$.ajax({
						url: '/kmarket2/product/cartInert',
						type: 'post',
						data: JSON.stringify(jsonData),
						dataType: 'json',
						contentType:'application/json',
						success: function(data){
							if(confirm('장바구니에 추가되었습니다.\n장바구니로 이동하시겠습니까?')){
								location.href = "/kmarket2/product/cart";
							
							}else{
								return;
							}
						}
					});
				}else{
					alert('로그인 후 이용 가능합니다.');
				}
			});
})
