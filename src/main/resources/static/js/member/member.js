$(()=>{
	
	
	
});

/*$.validator.addMethod("regexUid", function(value, element, regexp){
	let regex = new RegExp(regexp);
	let result = regex.test(value);
	return result;
});*/

const validateForm = () => {
	$('form').validate({
		rules:{
			uid:{
				required: true,
				pattern: "^[a-zA-Z0-9]{4,12}$"
			},
			pass1:{
				required: true,
				pattern: "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,12}$"
				
			},
			pass2:{
				required: true,
				equalTo: "#pass1",
			},
			name:{
				required: true
			},
			gender:{
				required: true
			},
			email:{
				required: true,
				email: true
			},
			hp:{
				required: true
			}
			
		},
		messages:{
			uid:{
				required: "아이디는 필수입력사항입니다.",
				pattern: "영문, 숫자로 4~12자까지 설정해 주세요.",
			},
			pass1:{
				required: "비밀번호는 필수입력사항입니다.",
				pattern: "영문, 숫자, 특수문자를 조합하여 8~12자까지 설정해 주세요.",
			},
			pass2:{
				required: "비밀번호는 필수입력사항입니다.",
				equalTo: "비밀번호가 일치하지 않습니다.",
			},
			name:{
				required: "이름은 필수입력사항입니다."
			},
			gender:{
				required: "성별은 필수입력사항입니다."
			},
			email:{
				required: "이메일은 필수입력사항입니다.",
				email: "이메일 형식을 확인해주세요"
			},
			hp:{
				required: "연락처는 필수입력사항입니다."
			}
		},
        errorPlacement: function(err, element){
          if(element.is(":radio") || element.is(":checkbox")){
              element.parent().after(err);
          } else {
              element.after(err);
          }
        },
		submitHandler: function(){
			console.log("submit!!");
		}
	});
	
}