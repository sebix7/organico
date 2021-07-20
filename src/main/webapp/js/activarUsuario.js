$(document).ready(function () {
	
document.querySelectorAll('.activa').forEach(item => {

           item.addEventListener('click', event => {
             var id = item.value;
                 
                $.ajax({						
				type: 'GET',
				url: "activarUsuario?id="+id,
				dataType: 'json',	//Que tipo de respuesta espera
				data: JSON.stringify(id),	//Como lo manda
				contentType: "application/json; charset=utf-8",
           
	             }); 
	              alert("Se ha activado al usuario .Muchas Gracias.")
                   document.location.reload(true);
          
  })
   
  
})
      

});