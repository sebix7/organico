$(document).ready(function () { 
 
//debido a que ver perfil es un boton HTMLcollection,se utiliza un bucle.
// Se llama a querySelectorAll () en todos los elementos con una clase específica(boton)
//, luego se usa forEach () para iterar sobre ellos.
//item.value me da el id que necesito mandar al servidor.

document.querySelectorAll('.boton').forEach(item => {
           item.addEventListener('click', event => {
             var id = item.value;
            
                
                 $.ajax({						
				type: 'GET',
				url: "verPerfil?id="+id,
				dataType: 'json',	//Que tipo de respuesta espera
				data: JSON.stringify(id),	//Como lo manda
				contentType: "application/json; charset=utf-8",
				success : function(data){
			    
                	$('#nombre').text(data.nombre);
                	$('#email').text(data.email);
                	$('#rol').text(data.rol);
                
					
	         }
	      });             
                
  })
})
     
     //Si algo sale mal, sale un alert con el codigo de error
	function msjError(xhr, ajaxOptions, thrownError){
		alert("Hubo un Error: " + xhr.status);
		console.log(xhr);
	}				        
});

  