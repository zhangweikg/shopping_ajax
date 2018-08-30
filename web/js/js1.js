function isEmail(str) {
	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
	return reg.test(str);
}

function isPassword(str) {
	var reg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;
	return reg.test(str);
}

function selText() {
	document.getElementById('jianli').select();
}

function selTxt_Name() {
	document.getElementById('txt_name').select();
}

function checkName() {
	var divn1 = document.getElementById("div1");
	var divn2 = document.getElementById("div2");
	var divn3 = document.getElementById("div3");
	var name = document.getElementById("txt_name").value;
	divn1.style.display = "none";
	if(name != "" && name.length >= 6 && name.length <= 12) {
		//		divn1.style.display="none";
		divn2.style.display = "none";
		divn3.style.display = "block";
		//		none:隐藏内容
		//		block:显示内容
		return true;
	} else {
		//		divn1.style.display="none";
		divn2.style.display = "block";
		divn3.style.display = "none";
		return false;
	}
}

function checkPassword() {
	//  方法一：
	//	var password = document.getElementById("pwd").value;
	//	if(password.length >= 6 && password.length <= 12) {
	//		divPassword.innerHTML = "<font color='green'>顺利通过</font>";
	//		//		不能写成:form1.divPassword.innerHTML="error";
	//		return true;
	//	} else {
	//		divPassword.innerHTML = "<font color='red'>error</font>";
	//		return false;
	//	}

	//方法二：
	var s = document.getElementById("pwd").value;
	if(isPassword(s)) {
		divPassword.innerHTML = "<font color='green'>顺利通过</font>";
		return true;
	} else {
		divPassword.innerHTML = "<font color='red'>error</font>";
		return false;
	}
}

function checkEmail() {
	var s = document.getElementById("email").value;
	var demail = document.getElementById("divEmail");
	if(!isEmail(s)) {
		demail.innerHTML = "<font color='red'>error</font>";
		return false;
	} else {
		demail.innerHTML = "<font color='black'>顺利通过</font>";
		return true;
	}
}

function checkConfirmed() {
	//	方法一:

	//	var repwd = obj.value;
	//	var pwd = form1.pwd.value;
	////	var pwd = document.getElementById("pwd").value;
	//	var deconfirmed = document.getElementById("divconfirmed");
	//	if(pwd != repwd || repwd == "") {
	//		deconfirmed.innerHTML = "<font color='red'>error</font>";
	//	} else {
	//		deconfirmed.innerHTML = "<font color='green'>顺利通过</font>";
	//	}

	//	方法二:

	var pwd = document.getElementById("pwd").value;
	var repwd = document.getElementById("confirmed").value;
	//	var repwd = obj.value;
	var deconfirmed = document.getElementById("divconfirmed");
	if(pwd != repwd || repwd == "") {
		deconfirmed.innerHTML = "<font color='red'>error</font>";
		return false;
	} else {
		deconfirmed.innerHTML = "<font color='green'>顺利通过</font>";
		return true;
	}

	//	获得值的三种方式:
	//	1.var repwd = obj.value;
	//	2.var pwd = document.getElementById("pwd").value;
	//	3.var pwd = form1.pwd.value;
}

function isIDnumber(str) {
	var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
	return reg.test(str);
}

function checkIDnumber() {
	var id = document.getElementById("ID").value;
	var deid = document.getElementById("divID");
	if(isIDnumber(id)) {
		deid.innerHTML = "<font color='green'>顺利通过</font>"
		return true;
	} else {
		deid.innerHTML = "<font color='red'>error</font>"
		return false;
	}
}

function checkAge() {
	var reg = /^[-+]?\d+$/;
	var tel = document.getElementById("age").value;
	var deid = document.getElementById("divage");
	if(reg.test(tel) && tel > 0) {
		deid.innerHTML = "<font color='green'>顺利通过</font>";
		return true;
	} else {
		deid.innerHTML = "<font color='red'>error</font>";
		return false;
	}
}

function checkSex() {
	var deid = document.getElementById("divsex");
	if(form1.sex1.checked || form1.sex2.checked) {
		deid.innerHTML = "<font color='green'>顺利通过</font>";
		return true;
	} else {
		deid.innerHTML = "<font color='red'>error</font>";
		return false;
	}
}

function checkHobby() {
	var count = 0;
	var deid = document.getElementById("divhobby");
	for(i = 0; i < 3; i++) {
		if(form1.habby[i].checked == true)
			count++;
	}
	if(count < 2) {
		deid.innerHTML = "<font color='red'>请至少选两项</font>";
		return false;
	} else {
		deid.innerHTML = "<font color='green'>顺利通过</font>";
		return true;
	}
}

function checkJianli() {
	var jianli = document.getElementById("jianli").value;
	var deid = document.getElementById("divjianli");
	if(jianli.length < 10) {
		deid.innerHTML = "<font color='red'>请至少输入10个字符</font>";
		return false;
	} else {
		deid.innerHTML = "<font color='green'>顺利通过</font>";
		return true;
	}
}

function checkXueli() {
	var xueli = document.getElementById("xueli").value;
	var deid = document.getElementById("divxueli");
	if(xueli == 0) {
		deid.innerHTML = "<font color='red'>请选择</font>";
		return false;
	} else {
		deid.innerHTML = "<font color='green'>顺利通过</font>";
		return true;
	}
}


function checkForm() {
	var flag2 = true;
	if(!checkName()) flag2 = false;
	if(!checkPassword()) flag2 = false;
	if(!checkIDnumber()) flag2 = false;
	if(!checkConfirmed()) flag2 = false;
	if(!checkAge()) flag2 = false;
	if(!checkSex()) flag2 = false;
	if(!checkHobby()) flag2 = false;
	if(!checkJianli()) flag2 = false;
	if(!checkXueli()) flag2 = false;
	if(!checkEmail()) flag2 = false;
	return flag2;
}