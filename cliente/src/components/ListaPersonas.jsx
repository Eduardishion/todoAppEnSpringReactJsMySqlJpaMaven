import React from 'react';
import Persona from './Persona';


const listaPersonas = () =>{
    //componente con estado
    state = {users: []}

 
    componentDidMount() {
        fetch('/users').then(res => res.json()).then(users => this.setState({ users }));
    }
  

    return(
        
        <div>

            <ul>

                {
                  this.state.courses.map(course => (
                        <Persona
                            key ={course.id}
                            id  ={course.id}
                            name={course.username}
                        />

                    ))
                }
            </ul>
        </div>
    )
}

export default listaPersonas


