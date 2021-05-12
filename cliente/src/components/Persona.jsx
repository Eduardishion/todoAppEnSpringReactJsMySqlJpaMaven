import React from 'react'

const Persona = (props) => {
    return(

        <div>
            <ul>

                <li>{props.id} - {props.username} </li>

            </ul>

        </div>

        )
}

export default Persona