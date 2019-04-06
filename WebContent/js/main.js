var sexoimg = "";

function enviarSexo(sexo){
	if(sexo == "M"){
		sexoimg = "user-m";
	}else if(sexo == "F"){
		sexoimg = "user-f";
	}
}




window.onload = function() {
	callBot("");
}

var imageUsuario = "";

var btnSend = document.querySelector("#sendQuestion");

btnSend.addEventListener("click", function(event) {
	event.preventDefault();
	
	var question = document.querySelector("#question");
	
	var sexo = document.querySelector("#sexo");
	createMessage(question.value, "user", sexoimg);

	
	callBot(question.value); 
	
	question.value = "";
});

function createMessage(message, type, sexoimg, pulse = false) {
	var chat = document.querySelector("#textchat");
	var div = createDiv(message, type, sexoimg);
	chat.appendChild(div);
	scrollDivDown(chat);
	if (pulse) makePulse(chat);
}

function makePulse(element) {
	element.classList.add("pulse-animation");
	setTimeout(function() {
		element.classList.remove("pulse-animation");
	}, 2500);
}

function callBot(message) {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "chat", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.addEventListener("load", function() {
		if (xhr.status == 200) {
			var resposta = JSON.parse(xhr.responseText);
			createMessage(resposta.bot[resposta.bot.length - 1], "bot", "bot", true);
		} else {
			console.log(xhr.status);
			console.log(xhr.responseText);
		}
	});

	data = "question=" + message;
	xhr.send(data);
}

function createDiv(text, type, typeImage) {
	var div = document.createElement("div");
	var img = createImage(typeImage);
	var p = createText(text);
	div.classList.add("chat" + type);
	div.appendChild(img);
	div.appendChild(p);
	return div;
}



function createImage(type) {
	var img = document.createElement("img"); 
	img.setAttribute("src", "img/"+type+".png"); 
	img.classList.add("icon" + type); 
	
	return img;
}

function createText(text) {
	var p = document.createElement("p");
	p.textContent = text;
	return p;
}

function scrollDivDown(div) {
	for (var i = 0; i < div.offsetHeight; i++) {
		div.scrollTop++;
	}
}

