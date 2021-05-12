import React, { Component } from 'react';       //libreria  principal para usar JSX
import {Button,Table} from 'reactstrap';        //libreria de sintaxis bootstrap con JSX
//import axios from 'axios';                      //libreria axios para tratar peticiones al servidor
import {ToastContainer,toast} from 'react-toastify';          //toastify parapoder crear notificaciones en la aplicacion 
import 'react-toastify/dist/ReactToastify.css'  //estilos de notificaciones Toastify


//para utilizar esta interfaz grafica completa de CRUD para SPRING BOOT
//solo se modifico en los metodos fetch la url asi el servidor que apunta y donde se encuentran los datos
//1.- que fue la siguiente ruta  http://localhost:9090/api/tareas/ en todos los fetch

//2.- lo siguiente que se modifico fue el id que por alguna razon se renombro de _id a id 

//3.-se agrego un catch al eliminar 

//clase del componenteApp
class componenteApp extends Component {

    //contructor de la componenteApp
    constructor(){
        //con el coonstructor nos permite inicializar el componente
        //contructor de la clase y del componente web
        //que nos permite heradar todos metodos,fucionalidades,clases, asi como manipular estado del componente  de react 
        super();
        
        //estado del componente web de react son las propiedates 
        this.state={
            //desde aqui podemos inicilizar valores de las propiedades del componente 
            //podemos inicializar los valores vacios al iniciar el componente
            titulo:'',
            descrip:'',
            tareas:[],
            id:'' 
        };
        //vincular el metodo al estado del componente 
        this.AgregarYActulizarTarea = this.AgregarYActulizarTarea.bind(this);
        this.ManejarElCambio = this.ManejarElCambio.bind(this);
    }
    
    //componentDidMount se usa para cuando deseamos cargar datos alguna otra cosa inmediatemente despues iniciar la interfaz y lo primero que se renderiza del  componente
    componentDidMount(){
        //console.log("el componente fue montado...");
        this.Obtenertareas();
    }
    /***************************Eventos o metodos del componente*************************************/
    //eventp o metodo para  inssertay o actulizar una tarea, que hace una peticion al servidor por metodo POST para insertar o por metodo PUT para actualizar
    AgregarYActulizarTarea(e){
        if(this.state.id){

            //axios.get
            //axios.post
            //axios.put
            //axios.delete

            //console.log(">>>>>>>>>>>>>>>>>>>>>>>><"+this.state._id)
            console.log("si exite un id actulizalo");
            fetch('http://localhost:9090/api/tareas/'+this.state.id, {
                method: 'PUT',
                body: JSON.stringify(this.state),
                headers:{
                    "Accept": "application/json",
                    "Content-Type": "application/json"
                }  
            })
            .then(res => res.json())
            .then(data => {
                console.log(data);
                this.setState({titulo:"", descrip:"", id:""});
                this.Obtenertareas();
                toast.success("Tarea actualizada...",{
                    position: toast.BOTTOM_LEFT
                });
            });
        }else{
            console.log("no exite un id de inicio, inserta nuevo registro");

            //para verificar si esta funcionando el metodo al dar clik por mensaje en consola 
            //console.log("agregar tarea...");
            //para mostrar el estado del componente por consola 
            //console.log(this.state);

            //para mandar datos hacia el servidor usaremos el metodo fetch 
            //se debe especificar hacia que ruta se hara la peticion en este caso "/api/tareas"
            //que es el api que ya hemos creado 

            //en ves de usar fetch como metodo de envio de datos se puede usar la libreria superint, asios 
            //para hacer una peticion al servidor en este caso de insertar datos por el metodo post en formato json
            fetch("http://localhost:9090/api/tareas/",{
                //metodo post se usa para insertar datos 
                method:"POST",
                //para convertir el estado a un string json   
                body: JSON.stringify(this.state),
                headers:{
                    "Accept": "application/json",
                    "Content-Type": "application/json"
                }   
            })

            //.then(res => console.log(res))
            .then(res => res.json())
            //.then(data => console.log(data))
            .then(data => {
                console.log(data);
                //intentar mandar una notificacion de que ha sido enviada la peticion 
                //de forma grafica 
                //<ComponenteToast/>
                this.setState({titulo:"",descrip:""}); 
                this.Obtenertareas();
                toast.success("Tarea agregada...",{
                    position: toast.BOTTOM_LEFT
                });
            })  
            .catch(err => {
                console.log(err)
            });

        }
            
        
        //para evitar refresco en la vista al enviar datos 
        e.preventDefault();
    }
    //evento o metodo mostrar y listar los registros , que hace una peticion al servidor por el metodo GET
    Obtenertareas(){
        fetch("http://localhost:9090/api/tareas/")
        .then(res => res.json())
        //.then(data => console.log(data))
        .then(data => {
        //console.log(data);
        this.setState({tareas:data});
            console.log(this.state.tareas);
        })
    }
    //evento o metodo eliminar registros, que hace una peticion al servidor por el metodo DELETE
    EliminarTarea(id){
       //if(window.confirm("estas seguro que deseas eliminar este registro...")){
            //para concatenar con + y con {$}
        console.log("eliminando tarea...",id);
            //peticion al servidorr para eliminar 
            //manera de concatenas con +
            //fetch("/api/tareas/"+id)
            //manera de concatenas con ${}
        fetch('http://localhost:9090/api/tareas/'+id,{
            method:'DELETE',
            headers:{
                "Accept": "application/json",
                "Content-Type": "application/json"
            }
        })
        .then(res => res.json())    
        .then(data => {
            console.log(data);
            this.Obtenertareas();
        }).catch(err => {
            console.log(err)
            this.Obtenertareas();
            toast.error("Tarea elimnada...",{
                position: toast.BOTTOM_LEFT
            });
        });

        // fetch('http://localhost:9090/api/tareas/'+id,{
        //     method: 'DELETE',
        //     headers:{
        //         "Accept": "application/json",
        //         "Content-Type": "application/json"
        //     }
        // })
        // .then(res => res.json())

       //}
    }
    //evento o metodo que obtiene el registro por medio del ID seleccionado, donde se hace una peticion de un solo resgistro 
    async ObtenerIdParaActualizar(id){
            // //console.log("actualizando tarea..."+id);
            await fetch('http://localhost:9090/api/tareas/'+id)
                .then(res => res.json())//convierte la peticion a formato json
                .then(data => {
                    console.log(data);
                    //actualiza el estado
                    this.setState({
                        titulo: data.titulo,
                        descrip: data.descrip,
                        id: data.id
                    })
            });// mustra los datos obtenidos por consola

          

    }
    //evento que supervisa y inserion de datos en el formuario 
    ManejarElCambio(e){
        //e.target obtiene todo el elemento al detectar el evento  
        //e.target.value obtiene el valor especifico del elemento al detectar el evento  
        //e.target.name obtiene el nombre especifico del elemento al detectar el evento 
        //console.log(e.target.name);
        //obtenemos el nombre y el valor de target o elemento input del formulario 
        const {name, value } = e.target;
        //cambiamos el estado del componente mediante el metodo setState
        this.setState({
            [name]:value
        });
    }
    /***************************Eventos o metodos del componente*************************************/
    
    
    //metodo para renderizar contenido en html dinamico mediante JSX, estas no son stiqutas HTML
    render() {
        return (
             <div>
                <div className="row fondoDiv3 ">
                    <div className="col-12">
                        <h1>Operaciones CRUD with SPRING...</h1>
                        <h6>Create -Insertar- , Read -Mostrar-, Update -Actulizar-, Delete -Eliminar-</h6>
                    </div>
                </div>
                <div className="row">
                    <div className="col-4 fondoDiv1">
                        <h3>Ingresar datos</h3>
                        <form onSubmit={this.AgregarYActulizarTarea} method="post">
                            <div className="row">
                                <div className="col-12">
                                    {/*usamos la propieddad name para identificar a lo imputs, a este lo llamamos titulo*/}
                                    {/*en este caso verficamos cuando se escriba cualquier cosa con el evento onchange por el metodo ManejarElCambio*/}
                                    <input type="text" name="titulo"  placeholder="Titulo" onChange={this.ManejarElCambio} value={this.state.titulo}/>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-12">
                                    {/*usamos la propieddad name para identificar a lo imputs , a este lo llamamos descrip*/}
                                    {/*en este caso verficamos cuando se escriba cualquier cosa con el evento onchange por el metodo ManejarElCambio*/}
                                    {/* <textarea type="text" name="descrip"  placeholder="Descripcion" onChange={this.ManejarElCambio} value={this.state.descrip}></textarea> */}
                                    <input type="text" name="descrip"  placeholder="Descripcion" onChange={this.ManejarElCambio} value={this.state.descrip}></input>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-12">
                                    <Button variant="primary" type="submit">Insertar</Button><br/>
                                </div>
                            </div>
                            <ToastContainer autoClose={1500}/>
                        </form>
                    </div>
                    <div className="col-8 fondoDiv2">
                    <h3>Muestreo de datos </h3>
                        <Table hover size="sm" responsive>
                        <thead>
                                <tr>
                                    <th>Titulo</th>
                                    <th>Descripcion</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.tareas.map(tarea => {
                                        return(
                                            <tr key = {tarea.id}>
                                                <td> {tarea.titulo} </td>
                                                <td> {tarea.descrip} </td>
                                                <td>
                                                    <Button variant="primary" onClick={() => this.EliminarTarea(tarea.id)}>Eliminar</Button><br/>
                                                </td>
                                                <td>
                                                    <Button variant="primary" onClick={() => this.ObtenerIdParaActualizar(tarea.id)}>Actualizar</Button><br/>
                                                </td>
                                            </tr> 
                                        )
                                })}
                            </tbody>
                        </Table>
                    </div>
                </div> 
             </div> 
        );
    }

}

//para poder exportar el ponponente y ser usado en otro componente 
export default componenteApp;