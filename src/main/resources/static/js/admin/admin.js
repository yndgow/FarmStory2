/*
	날짜 : 2023/02/17 
	이름 : 김지홍
	내용 : admin 의 자바스크립트 함수 모음
*/

document.addEventListener("DOMContentLoaded", ()=>{
	asideSlide();
});
// admin/register 1차 분류 선택시 2차 분류 가져오기
function cateList(){
	let admin_cate1 = document.getElementById("admin_cate1");
    let admin_cate2 = document.getElementById("admin_cate2");
    admin_cate1.addEventListener("change", ()=>{
		let cate1 = admin_cate1.value;
		let tag = `<option value="" selected>2차 분류 선택</option>`;
		fetch("/kmarket2/cate1/" + cate1)
			.then(res => res.json())
    		.then((data) => {
				console.log(data);
      			admin_cate2.innerHTML = "";
				for (const e of data) {
		        	tag +=`<option value="${e.cate2}">${e.c2Name}</option>`;
      			}
      			admin_cate2.insertAdjacentHTML('beforeend', tag);
      
			});
	});
}
// admin/register point 계산(price 의 10%)
function calcPoint(){
	let admin_price = document.getElementById("admin_price");
	let admin_point = document.getElementById("admin_point");
	admin_price.addEventListener("focusout", ()=>{
		admin_point.value = Math.floor(Number(admin_price.value) * 0.1);	
	});
}
// admin 공통 aside 슬라이드
function asideSlide(){
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
}
// admin list 검색 기능
let totalPosts = 0;

async function updateTable(page) {
	let admin_condition = document.getElementById('admin_condition');
	let search_value = document.getElementById('search_value');
	//let btn_admin_search  = document.getElementById('btn_admin_search');
	let table  = document.getElementById('admin_table');
	const response = await fetch(
		'/kmarket2/admin/search?' 
		+ admin_condition.value 
		+ '=' 
		+ search_value.value 
		+ '&pageNum=' 
		+ page, {async: false});
	const data = await response.json();
	totalPosts = data.totalElements;
	table.tBodies[0].innerHTML = '';
	data.content.forEach(product => {
    const row = document.createElement('tr');
    row.innerHTML = 
    `<td><input type="checkbox" name="" id="" class="form-check-input"></td>
        <td class="admin_list_img"><img src="/kmarket2/images/${product.thumb1}" alt="" class="img-fluid"></td>
        <td>${product.prodNo}</td>
        <td>${product.prodName}</td>
		<td>${product.price}</td>
		<td>${product.discount}</td>
		<td>${product.point}</td>
		<td>${product.stock}</td>
		<td>${product.seller}</td>
		<td>${product.hit}</td>
        <td><a href="">[수정]</a><a href="">[삭제]</a></td>`;
        table.tBodies[0].appendChild(row);
  	});
  	updatePagination(page);
}

function updatePagination(currentPage) {
  const pageSize = 10;
  const totalPages = Math.ceil(totalPosts / pageSize);
  const pagesPerGroup = 10;
	
  const pagination = document.getElementById('paging_nav');
  let pageGroup = Math.floor((currentPage - 1) / pagesPerGroup) + 1;
  let startPage = (pageGroup - 1) * pagesPerGroup + 1;
  let endPage = Math.min(startPage + pagesPerGroup - 1, totalPages);

  let paginationHtml = '<nav><ul class="pagination justify-content-center">';

  if (startPage > 1) {
    paginationHtml += `
    <li>
    	<a href="javascript:void(0);" onclick="updateTable(${startPage - 1})" aria-label="Previous" class="page-link">
    		<span aria-hidden="true">&laquo;</span>
    	</a>
	</li>`;
  }

  for (let i = startPage; i <= endPage; i++) {

    paginationHtml += `
    <li class="page-item">
    	<a href="javascript:void(0);" onclick="updateTable(${i})" class="page-link curPage">
    		${i}
		</a>
	</li>`;
  }

  if (endPage < totalPages) {
    paginationHtml += `
    <li class="page-item">
    	<a href="javascript:void(0);" onclick="updateTable(${endPage + 1})" aria-label="Next" class="page-link">
    		<span aria-hidden="true">&raquo;</span>
		</a>
	</li>`;
  }

  paginationHtml += '</ul></nav>';

  pagination.innerHTML = paginationHtml;
  let curPage = document.getElementsByClassName('curPage');
  currentPage = currentPage > 10 ? currentPage - 10 : currentPage;
  curPage[currentPage-1].classList.add('active');
}

function adminDeleteNotice(){
	let deleteList = document.getElementsByClassName('btnDeleteNotice');
	for(let i=0; i < deleteList.length; i++){
		deleteList[i].addEventListener('click', function(e){
			let id = e.target.id;
			e.preventDefault();
			fetch('/kmarket2/admin/cs/notice/delete?no='+id,{method:"DELETE",})
			.then(res => res.json())
			.then(data =>{
				console.log(data);
			})
		});
	}
}
