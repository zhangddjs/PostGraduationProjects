function checkForm(){

        var bookNumber  = document.myForm.bookNumber.value;
	if(bookNumber==""){
		alert("书号不能为空!");
		document.myForm.bookNumber.focus();
		return false;
	}
	var bookName  = document.myForm.bookName.value;
	if(bookName==""){
		alert("书名不能为空!");
		//调用表单元素对象的focus方法使得该表单元素对象重新获得输入焦点
		document.myForm.bookName.focus();
		return false;
	}
	var writer  = document.myForm.writer.value;
	if(writer==""){
		alert("作者不能为空!");
		document.myForm.writer.focus();
		return false;
	}
	var pub = document.myForm.publisher;
	var flag = false;
	for(var i=1; i<pub.length;i++){
		if(pub[i].selected){
			flag = true;
		}
	}
	if(!flag){
		alert("请选择出版社!");
		return false;
	}
	var sellDate  = document.myForm.sellDate.value;
	if(sellDate==""){
		alert("请选择出版日期!");
		document.myForm.sellDate.focus();
		return false;
	}
	var price  = document.myForm.price.value;
	if(price==""){
		alert("请输入价格!");
		document.myForm.price.focus();
		return false;
	}
	var place = document.myForm.place;
	var flag = false
	for(var i = 1; i < place.length; i++){
		if(place[i].selected){
			flag = true
		}
	}
	if (!flag) {
		alert("请选择库存位置!");
		return false;
	}
		var kind = document.getElementsByName("kind");
	var flag2 = false;
	for(i=0;i<kind.length;i++){
		if(kind[i].checked){
			flag2 = true;
		}
	}	
	if(!flag2){
 		alert("请选择种类!");
		return false;
	}
}