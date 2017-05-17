const React=require('react');
const ReactDOM=require('react-dom');
//const client=require('./client');

import axios from 'axios';

class App extends React.Component{

    constructor(props){
        super(props);
        this.state={jobs: []};
    }

    componentDidMount(){
        console.log("start componentDidMount");
    axios.get('http://localhost:8080/job/findAll')
      .then(res => {
        const posts = res.data.data.map(obj => obj.data);
        this.setState({ posts });
      });

//        client({method:'GET', path: 'http://localhost:8080/job/findAll'}).done(response => {
//            this.setState({jobs:response.entity})})
//            console.log("end componentDidMount");
    }

    render() {
        return (
            <JobList jobs={this.state.jobs} />
        )
    }
}

class JobList extends React.Component{

    render(){
        var jobs = this.props.jobs.map(job => 
            <Job key={job.id} job={job} />    
        );
        return (
            <table>
                <tbody>
                    <tr>
                        <th>Id</th>
                        <th>Customer Name</th>
                        <th>Date</th>
                    </tr>    
                    {jobs}
                </tbody>
            </table>
        )
    }
}

class Job extends React.Component{

    render(){
        return(
            <tr>
                <td>{this.props.job.id}</td>
                <td>{this.props.job.customer.name}</td>
                <td>{this.props.job.date}</td>
            </tr>    
        )
    }
}


ReactDOM.render(
    <App/>,
    document.getElementById('react')
);

