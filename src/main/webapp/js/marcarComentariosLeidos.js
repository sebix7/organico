$(document).ready(function () {
	
	var leido = document.getElementById('marcarLeido');
	leido.addEventListener('click',resultado);
	
	
	function resultado(e){
		
      var id = leido.value;
       

                 $.ajax({						
				type: 'GET',
				url: "marcarComentariosLeidos?id="+id,
				dataType: 'json',	//Que tipo de respuesta espera
				data: JSON.stringify(id),	//Como lo manda
				contentType: "application/json; charset=utf-8", 
	             });

                alert("Muchas Gracias.")
                document.location.reload(true); 
		
	}
	
	
	});