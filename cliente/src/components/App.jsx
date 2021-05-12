import React,{Component} from 'react'
import { Container } from 'reactstrap';
//import logo from './logo.svg';
import './App.css';
import ComponenteAppSring  from './conponentesSecundarios/componenteAppSpring';


//instaciacion de compoenenteCRUD

//clase para crear el componente de vista
class App extends Component{

  
  //contructor del compoenente 
  constructor(){
    //es necesario usar el super cuando se extiende de la clase component
    super()
    //se inicia el estado y se asigna un arreglo de datos 
    this.state={users: []}
  }

  render() {
    //se renderiza los datos que se han obtenido de al cargar el arreglo y solo se muestran 
    return (
      <Container>
          <div className="App">
               <ComponenteAppSring/>              {/* UI para back-end del framework Spring boot de java */}
          </div>
      </Container>
    );
  }
}

export default App;
