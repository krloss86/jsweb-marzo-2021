function validar() {

    let cantidad = document.getElementById('CANTIDAD').value;

    if(!cantidad || cantidad <= 0) {
		alert("Cantidad invalida");
    }else {
	    var str = $("#detalleArticuloForm").serialize();
	    $.post(`${context}/CarritoController`,str)
	  		.done(function( data ) {
	    		alert(data );
	  		}
	  	);
    }
    
}

function validarByFormId (formId) {

	let cantidad = $(`#CANTIDAD_${formId}`).val();

    if(!cantidad || cantidad < 0) {
		alert("Cantidad invalida");
    }else {
	    var str = $(`#form_${formId}`).serialize();
	    $.post(`${context}/CarritoController`,str)
	  		.done(function( data ) {
	    		alert(data );
	  		}
	  	);
    }
}

function incrementar() {
	let actual = $('#CANTIDAD').val();
	
	if(actual) {
		actual = +actual;
	}else {
		actual = 0;
	}
	actual ++;
	if(actual > 999) {
		actual  = 999;
	}
	$('#CANTIDAD').val(actual);
}

function decrementar() {
	let actual = $('#CANTIDAD').val();
	
	if(actual) {
		actual = +actual;
	}else {
		actual = 0;
	}
	actual --;
	if(actual < 0) {
		actual  = 0;
	}
	$('#CANTIDAD').val(actual);
}

function actualizarCarrito(id) {
	//capturo la cantidad asociada al id
	let cantidad = $(`#CANTIDAD_${id}`).val();
	
	//validaciones de cantidad
	if(!cantidad || cantidad <0 || cantidad > 999  ) {
		alert('Cantidad invalida');
		return false;
	}
			
	//actualizo el id
	$('#CANTIDAD').val(cantidad);
	$('#ID').val(id);
}

//botones en shoppingCart
function actualizar(id) {
	
	actualizarCarrito(id);
	
	//submit del formulario
	$('#frmCarrito').attr('method','GET');
	$('#frmCarrito').attr('action',context + '/ActualizarCarritoController');
	$('#frmCarrito').submit();
}

//botones en shoppingCart
function eliminar(id) {

	if(confirm('¿Eliminar articulo?')) {
		actualizarCarrito(id);
		
		//submit del formulario
		$('#frmCarrito').attr('method','GET');
		$('#frmCarrito').submit();
	}
}

try {
	//boton de detalle de articulo 
	$('#btnAdd').click(validar);
}catch(e) {
	console.log(e);
}

try {
	// todo los botones de listado general
	$('.btnAdd').click(function() {
		validarByFormId(`${this.id}`);
	});
}catch(e) {
	console.log(e);
}

try {
	//botones en detalle de articulo
	$('#btnIncrementar').click(incrementar);
	$('#btnDecrementar').click(decrementar);
}catch(e) {
	console.log(e);
}

try {
	// todo los botones de listado general
	$('.btnActualizar').click(function() {
		actualizar(`${this.id}`);
	});
	$('.btnEliminar').click(function() {
		eliminar(`${this.id}`);
	});
	}catch(e) {
	console.log(e);
}
