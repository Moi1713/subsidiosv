//Funciones de SweetAlert2


//confirmación para guardar un registro - PENDIENTE -

function guardar() {
    Swal.fire({
        title: '¿Está seguro?',
        text: "Se guardará un nuevo registro",
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
                url:"/roles/guardar",
                data: $("#formregistro").serialize(),
                success: function(res) {
                    console.log(res);
                }
            });
            Swal.fire({
                title: '¡Guardado!',
                text: 'El registro ha sido creado exitosamente.',
                icon: 'success',
                confirmButtonColor: '#3085d6',
                confirmButtonText: 'Aceptar',
            }).then((Result)=>{
                if(Result){
                    location.href="/roles";
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