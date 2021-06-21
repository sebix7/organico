$(document).ready(function () { 
 
    function ajaxValoracion() {
        $.ajax({
            type: "POST",
            url: "guardarComentario",
            dataType: "json",
            data: JSON.stringify({"idcombo": $("#Idcombo").val(), "comentario":$("#comentario").val()}),
            contentType : 'application/json; charset=utf-8',      
        });
    }

  $("#boton").click(function () {
        ajaxValoracion();
        alert("Se ha enviado el comentario.Muchas Gracias.")
        document.location.reload(true);
    });
 

});
