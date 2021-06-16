$(document).ready(function () { 
 
    function ajaxValoracion(valoracion) {
        $.ajax({
            type: "POST",
            url: "valorarcombos",
            dataType: "json",
            data: JSON.stringify({"idcombo": $("#Idcombo").val(), "validacion": valoracion }),
            contentType : 'application/json; charset=utf-8',
        });
    }

  $("#likeIcon").click(function () {
        ajaxValoracion(true);
        alert("Ha valorado de forma Positiva el combo.Muchas Gracias.")
        document.location.reload(true);
    });

    $("#dislikeIcon").click(function () {
        ajaxValoracion(false);
         alert("Ha valorado de forma negativa el combo.Muchas Gracias.")
         document.location.reload(true);
    });
 

});
