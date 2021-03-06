import React, { Component } from 'react'
import axios from 'axios';
import LateNightForm from "./late-night-form";
import {NotificationManager} from "react-notifications";

class LateNightConveyance extends Component {
    constructor(props) {
        super(props);

        this.state = {
            people: []
        };

        this.addPerson = this.addPerson.bind(this);
        this.deletePerson = this.deletePerson.bind(this);
    }

    componentDidMount() {
        this.getData();
    }

    getData = () => {
        axios.get('/getLNCEntry')
            .then(res => {
                this.setState({people: res.data});
            });
    };

    addPerson(id, name) {
        const bodyFormData = {
            name: name,
            employeeId: id
        };
        axios.post('/createLNCEntry', bodyFormData)
            .then(res => {
                this.setState({people: res.data});
                NotificationManager.success('Successfully added employee', 'Successful!', 2000);
            }).catch(err => {
            NotificationManager.error('Employee data already added', 'Error!');
        })
    }

    deletePerson(e, employeeId){ e.preventDefault(); {
        axios.get(`/updateLNCEntry/${employeeId}`)
            .then(res => {
                this.setState({people: res.data});
                NotificationManager.success('Successfully deleted employee', 'Successful!', 2000);
            }).catch(err => {
            NotificationManager.error(err.message, 'Error!');
        })
    }}

    render(){
        return (
            <section className="smart-filter-content">
                <h2 className="smart-filter-heading">Employee Register</h2>
                    <div>
                        <h2 className="smart-filter-heading">Enter employee details:</h2>
                        <LateNightForm addPerson={this.addPerson} />
                    </div>
                <div>
                    <h2 className="smart-filter-heading">Employee List:</h2>
                    <table className="responsive-table">
                        <thead>
                            <tr>
                                <th scope="col">Employee-Id</th>
                                <th scope="col">Name</th>
                                <th scope="col">CheckIn Time</th>
                                <th scope="col">CheckOut</th>
                            </tr>
                        </thead>
                        <tbody>
                        {this.state.people.map((person) => {
                            return (
                                <tr key={person.name}>
                                    <th scope="row" data-title="employeeId">{person.employeeId}</th>
                                    <td data-title="name">{person.name}</td>
                                    <td data-title="id">{person.checkInTime}</td>
                                    <td data-title="checkout button"> <button type="submit" onClick={(e) => this.deletePerson(e, person.employeeId)}>Check out</button></td>
                                </tr>
                            );
                        })}
                        </tbody>
                    </table>
                </div>
            </section>
        );
    }
}


export default LateNightConveyance;
