//Funciones de SweetAlert2


function save(link, redirect) {

    console.log("funciona");
    Swal.fire({
        title: '¿Está seguro?',
        text: "Se guardará el registro",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Si',
        cancelButtonText: 'No'
      }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                method: "POST",
                url: link,
                data: $("#formregistro").serialize(),
                success: function(res) {
                    console.log(res);
                }
            });
            Swal.fire({
                title: '¡Guardado!',
                text: 'El registro ha sido guardado exitosamente.',
                icon: 'success',
                confirmButtonColor: '#3085d6',
                confirmButtonText: 'Aceptar',
            }).then((Result)=>{
                if(Result){
                    location.href=redirect;
                }
            });
        }
      })

}


//Confirmación al eliminar un registro

function eliminar(link, redirect) {
    Swal.fire({
        title: '¿Está seguro?',
        text: "Se eliminará el registro seleccionado",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Si',
        cancelButtonText: 'No'
      }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                url: link,
                success: function(res) {
                    console.log(res);
                }
            });
            Swal.fire({
                title: '¡Borrado!',
                text: 'El registro ha sido eliminado exitosamente.',
                icon: 'success',
                confirmButtonColor: '#3085d6',
                confirmButtonText: 'Aceptar',
            }).then((Result)=>{
                if(Result){
                    location.href=redirect;
                }
            });
        }
      })
}

//Validar Registro

function validar(link, redirect) {
    Swal.fire({
        title: '¿Está seguro?',
        text: "Se validará la solicitud seleccionada",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Si',
        cancelButtonText: 'No'
      }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                method: "POST",
                url: link,
                success: function(result) {
                    console.log(result);
                     if (result.code == '0') {
                            Swal.fire({
                                 title: '¡Validación Exitosa!',
                                 text: result.msj,
                                 icon: 'success',
                                 confirmButtonColor: '#3085d6',
                                 confirmButtonText: 'Aceptar',
                                                    }).then((Result)=>{
                                                        if(Result){

                                                            location.href='/solicitudes/';
                                                        }
                                                       });
                    }else{
                        Swal.fire({
                                                         title: '¡Error de Validación!',
                                                         text: result.msj,
                                                         icon: 'error',
                                                         confirmButtonColor: '#3085d6',
                                                         confirmButtonText: 'Aceptar',
                                                                            }).then((Result)=>{
                                                                                              if(Result){

                                                                                                  location.href='/solicitudes/';
                                                                                              }
                                                                                          });
                    }

                }
            });

        }
      })
}