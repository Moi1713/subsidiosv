function eliminar(id) {
    Swal.fire({
        title: '¿Está seguro?',
        text: "¿Desea eliminar el registro?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Si',
        cancelButtonText: 'No'
      }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                url:"/roleliminar/"+id,
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
                    location.href="/roles";
                }
            });
        }
      })
}