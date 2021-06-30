$(document).ready(function () {
	
document.querySelectorAll('.boton').forEach(item => {

           item.addEventListener('click', event => {
             var id = item.value;
                 
                $.ajax({						
				type: 'GET',
				url: "cancelarPedido?id="+id,
				dataType: 'json',	//Que tipo de respuesta espera
				data: JSON.stringify(id),	//Como lo manda
				contentType: "application/json; charset=utf-8",
           
	             }); 
	           alert("Ha cancelado su pedido.Muchas Gracias.")
                   document.location.reload(true);
          
  })
   
  
})
      

});