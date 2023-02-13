document.addEventListener('DOMContentLoaded',()=>{
    qnaStat();
    asideAddClass();
});


// 문의내역 - 상태 변경(0 = 검토중, 1 = 답변완료) 
function qnaStat(){
    let answer = document.getElementsByClassName('qna_stat');
    for (let i = 0; i < answer.length; i++) {
        if(answer[i].textContent === '0'){
            answer[i].textContent = '검토중';
            answer[i].style.color = 'gray';
        }else{
            answer[i].textContent = '답변완료';
            answer[i].style.color = 'green';
        }
    }
}

// 
function asideAddClass(){
    
    let cur_url = window.location.href;
    let ext = cur_url.lastIndexOf("."); // . 의 마지막 인덱스 가져오기
    let last_index = cur_url.lastIndexOf("/"); // /의 마지막 인덱스 가져오기
    let str = cur_url.substring(last_index+1, ext); // 현재 주소에서 확장자를 뺀 마지막 경로 이름 가져오기 ex) home

    let asideOn = document.getElementsByClassName("aside_on");
    let asideNameList = ["ordered", "point", "coupon", "review", "qna", "info"];

    // str의 
    for(let i = 0; i<asideNameList.length; i++){
        if(str === asideNameList[i]){
            asideOn[i].setAttribute("class", "on");
        }    
    }
}