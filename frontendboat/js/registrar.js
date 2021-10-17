//Esta función ejecuta la petición asincrona al servidor de Oracle, envia una
//petición al ws de tipo POST
function registrar() {

    //crea un objeto javascript
    let datos={
        brand: $("#brand").val(),
        year: $("#year").val(),
        category:{"id":$("#category").val()},
        name: $("#name").val(),
        description:$("#description").val()
    }

    //convierte el objeto javascript a json antes de agregarlo a los datos de la petición
    let datosPeticion = JSON.stringify(datos);

    if (validar()){
        $.ajax({
            // la URL para la petición (url: "url al recurso o endpoint")
            url: "http://localhost:8081/api/Boat/save",
            
            // la información a enviar
            // (también es posible utilizar una cadena de datos)
            //si el metodo del servicio recibe datos, es necesario definir el parametro adicional
            data : datosPeticion,
    
            // especifica el tipo de petición http: POST, GET, PUT, DELETE
            type: 'POST',
    
            contentType:"application/JSON",
    
            // el tipo de información que se espera de respuesta
            //dataType: 'json',
    
            // código a ejecutar si la petición es satisfactoria;
            // la respuesta es pasada como argumento a la función
            success: function (respuesta) {
                //escribe en la consola del desarrollador para efectos de depuración
                console.log(respuesta);
                $("#mensajes").show(1000);
                $("#mensajes").html("Record saved...");
                $("#mensajes").hide(1000);
                listar();
                estadoInicial();
            },
    
            // código a ejecutar si la petición falla;
            // son pasados como argumentos a la función
            // el objeto de la petición en crudo y código de estatus de la petición
            error: function (xhr, status) {
                $("#mensajes").show(1000);
                $("#mensajes").html("Request error POST..." + status );
                //$("#mensajes").hide(1000);
            }
        });
    }
}

/**
 * Configura el aspecto de la página para ingresar un nuevo registro
 */
function activaNuevo(){
    listarCategorias();
    $("#nuevo").show(500);
    $("#name").focus();
    $("#editar").hide();
    $("#nuevoRegistro").hide(500)
    $("#listado").hide(500);
}

function listarCategorias() {
    $.ajax({
        // la URL para la petición (url: "url al recurso o endpoint")
        url: "http://localhost:8081/api/Category/all",
        
        // la información a enviar
        // (también es posible utilizar una cadena de datos)
        //si el metodo del servicio recibe datos, es necesario definir el parametro adicional
        //data : { id : 1, ...},

        // especifica el tipo de petición http: POST, GET, PUT, DELETE
        type: 'GET',

        // el tipo de información que se espera de respuesta
        dataType: 'json',

        // código a ejecutar si la petición es satisfactoria;
        // la respuesta es pasada como argumento a la función
        success: function (respuesta) {
            //escribe en la consola del desarrollador para efectos de depuración
            //console.log(respuesta);

            //recibe el arreglo 'items' de la respuesta a la petición
            armaListaCategorias(respuesta);
        },

        // código a ejecutar si la petición falla;
        // son pasados como argumentos a la función
        // el objeto de la petición en crudo y código de estatus de la petición
        error: function (xhr, status) {
            $("#mensajes").html("Problem executing the request ..." + status);
            //$("#mensajes").hide(1000);
        },

        // código a ejecutar sin importar si la petición falló o no
        complete: function (xhr, status) {
            $("#mensajes").html("Loading boat list ...");
            $("#mensajes").hide(1000);
        }
    });
}

function armaListaCategorias(items) {
    $("#listado").html("");
    $("#listado").show(500);
    //define variable javascript con la definicion inicial de la tabla, la primera fila y los
    //encabezados o títulos de la tabla
    var lista = ` <option value="">--Select a category--</option>`;
                  
    //recorre el arreglo de 'items' y construye dinamicamente la fila de datos de la tabla
    for (var i=0; i < items.length; i++) {
        lista +=`<option value="${items[i].id}">${items[i].name}</option>`;
    }

    //accede al elemento con id 'listado' y adiciona la tabla de datos a su html
    $("#category").html(lista);
}