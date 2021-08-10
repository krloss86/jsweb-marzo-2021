function showCC(){
	$('.cc').attr('required',true);
	$('#ccRow').show();
}

function hideCC() {
	$('.cc').attr('required',false);
	$('#ccRow').hide();
}

$('.ccCheckbox').on('click',function(){
	checkMedioPago(this.id);
});

function checkMedioPago(codigoMediopago){
	if(codigoMediopago == 'TARV') {
		showCC();
	}else {
		hideCC();
	}
}

function mantenerMedioPago() {
	let codigoMediopago = $('.cc :selected').val();
	checkMedioPago(codigoMediopago);
}

function genearOrden() {
	$('#frmCheckout').submit();
}

$('#btnCheckout').on('click', function(){
	$('#frmCheckout').submit();
});

mantenerMedioPago();