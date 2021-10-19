function validaesVacio(dato){
    return !dato.trim().length;
}

/**
 * Al ingresar un nuevo registro:
 * 
 * Ejecuta validaciones campo a campo
 */
function validar(){
    //obtiene valores
    let startdate = $("#startdate").val();
    let devolutiondate = $("#devolutiondate").val();
    let client = $("#client").val();
    let boat = $("#boat").val();
    let errores="";
    $("#mensajes").html("");

    //valida que los campos no sean vacios
    if( validaesVacio(startdate)) {
        errores="startdate vacio<br>";
        $("#mensajes").html(errores);
        $("#mensajes").show(500);
        $("#startdate").focus();
        return false;
    }else if( validaesVacio(devolutiondate)) { 
        errores="devolutiondate vacio<br>";
        $("#mensajes").html(errores);
        $("#mensajes").show(500);
        $("#devolutiondate").focus();
        return false;
    }else if( validaesVacio(client)) { 
        errores="client vacio<br>";
        $("#mensajes").html(errores);
        $("#mensajes").show(500);
        $("#client").focus();
        return false;
    }else if( validaesVacio(boat)) { 
        errores="boat vacio<br>";
        $("#mensajes").html(errores);
        $("#mensajes").show(500);
        $("#boat").focus();
        return false;
    }else{
        $("#mensajes").html("");
        $("#mensajes").hide(500);
        return true;

    }

    return true;
}

/**
 * Al actualizar un nuevo registro:
 * 
 * Ejecuta validaciones campo a campo
 */
 function validarEditar(){
    //obtiene valores
    let id = $("#idEdit").val();
    let messagetext = $("#messagetextEdit").val();
    let errores="";
    $("#mensajes").html("");

    //valida que los campos no sean vacios
    if( validaesVacio(id)) {
        errores="id vacio<br>";
        $("#mensajes").html(errores);
        $("#mensajes").show(500);
        $("#idEdit").focus();
        return false;
    }else if( validaesVacio(messagetext)) {
        errores="messagetext vacio<br>";
        $("#mensajes").html(errores);
        $("#mensajes").show(500);
        $("#nameEdit").focus();
        return false;
    }else{
        $("#mensajes").html("");
        $("#mensajes").hide(500);
        return true;
    }

    return true;
}