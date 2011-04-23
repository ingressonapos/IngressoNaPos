function alteraMascara(campo){
	$("#"+campo).mask("9999-999-9999");
}

function getDocHeight() {
    var D = document;
    return Math.max(
        Math.max(D.body.scrollHeight, D.documentElement.scrollHeight),
        Math.max(D.body.offsetHeight, D.documentElement.offsetHeight),
        Math.max(D.body.clientHeight, D.documentElement.clientHeight)
    );
}

function filtraNumerosValor(campo) {
	var s = "";
	var cp = "";
	vr = campo.value;
	tam = vr.length;
	for (i = 0; i < tam; i++) {
		if (vr.substring(i, i + 1) == "0" || vr.substring(i, i + 1) == "1"
				|| vr.substring(i, i + 1) == "2"
				|| vr.substring(i, i + 1) == "3"
				|| vr.substring(i, i + 1) == "4"
				|| vr.substring(i, i + 1) == "5"
				|| vr.substring(i, i + 1) == "6"
				|| vr.substring(i, i + 1) == "7"
				|| vr.substring(i, i + 1) == "8"
				|| vr.substring(i, i + 1) == "9") {
			s = s + vr.substring(i, i + 1);
		}
	}
	campo.value = s;
}
