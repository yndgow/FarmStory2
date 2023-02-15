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
    
    
    let admin_cate1 = document.getElementById("admin_cate1");
    let admin_cate2 = document.getElementById("admin_cate2");
    admin_cate1.addEventListener("change", ()=>{
		let cate1 = admin_cate1.value;
		let tag = `<option selected>2차 분류 선택</option>`;
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
});