$(document).ready(function () {
	
document.querySelectorAll('.NOactiva').forEach(item => {

           item.addEventListener('click', event => {
             var id = item.value;
                 
                $.ajax({						
				type: 'GET',
				url: "desactivarUsuario?id="+id,
				dataType: 'json',	//Que tipo de respuesta espera
				data: JSON.stringify(id),	//Como lo manda
				contentType: "application/json; charset=utf-8",
           
	             }); 
	              alert("Se ha desactivado al usuario .Muchas Gracias.")
                   document.location.reload(true);
          
  })
   
  
})
      

});