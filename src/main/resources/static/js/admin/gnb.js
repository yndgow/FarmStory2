document.addEventListener('DOMContentLoaded', () => {
    let gnb = $('#gnb > li > a');

    gnb.click(function (e) {
      e.preventDefault();
      let isOpen = $(this).next().is(':visible');

      if (isOpen) {
        $(this).next().slideUp(200);
      } else {
        $(this).next().slideDown(200);
      }
    });
    
    //cateList();
/*    
	let admin_price = document.getElementById("admin_price");
	let admin_point = document.getElementById("admin_point");
	admin_price.addEventListener("focusout", ()=>{
		admin_point.value = Math.floor(Number(admin_price.value) * 0.1);	
	});*/
	
/*	const form  = document.getElementById("admin_form");
	const input = document.getElementById("admin_input"); 
	form.addEventListener("submit", function(e){
		e.preventDefault();
		console.log("alert");
	});
	
	input.addEventListener("keypress", function(event) {
   		if (event.keyCode === 13) {
      		form.dispatchEvent(new Event("submit"));
    	}	
  	});*/
	
});

function cateList(){
	    let admin_cate1 = document.getElementById("admin_cate1");
    let admin_cate2 = document.getElementById("admin_cate2");
    admin_cate1.addEventListener("change", ()=>{
		let cate1 = admin_cate1.value;
		let tag = `<option value="" selected>2차 분류 선택</option>`;
		fetch("/kmarket2/cate1/" + cate1)
			.then(res => res.json())
    		.then((result) => {
      			admin_cate2.innerHTML = "";
				for (const it of result) {
		        	tag +=`<option value="${it.cate2}">${it.c2Name}</option>`;
      			}
      			admin_cate2.insertAdjacentHTML('beforeend', tag);
      
			});
	});
}