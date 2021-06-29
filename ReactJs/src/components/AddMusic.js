import axios from 'axios';
import React, {Component} from 'react';

export default class AddMusic extends Component {
  state = {
    Song_ID: '',
    Song_Title: '',
    Artist_Name: '',
    Album_Name: '',
    Song_Location: '',
    Description: '',
  };

  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value,
    });
  };

  handleSubmit = (event) => {
    event.preventDefault();
    console.log(this.state);

    const url =
      'https://music-react-app-default-rtdb.firebaseio.com/accounts.json';
    const data = {...this.state};

    axios
      .post(url, data)
      .then((resp) => {
        console.log(resp);
        if (resp.status === 200) {
          alert('Data Stored Successfully');
          this.setState({
            Song_ID: '',
            Song_Title: '',
            Artist_Name: '',
            Album_Name: '',
            Song_Location: '',
            Description: '',
          });

          this.props.history.push('/details');
        }
      })
      .catch((err) => {
        console.log(err);
      });
  };

  render() {
    return (
      <div className="container card col-md-10">
        <form className="container card-body" onSubmit={this.handleSubmit}>
          <div className="form-group ">
            <label htmlFor="song">Song_ID</label>
            <input
              type="text"
              className="form-control"
              id="user"
              aria-describedby="emailHelp"
              name="user"
              value={this.state.user}
              onChange={this.handleChange}
            />
          </div>

          <div className="form-group">
            <label htmlFor="exampleInputEmail1">Song_Title</label>
            <input
              type="text"
              className="form-control"
              id="exampleInputEmail1"
              aria-describedby="emailHelp"
              name="email"
              value={this.state.email}
              onChange={this.handleChange}
            />
          </div>
          <div className="form-group">
            <label htmlFor="txt">Artist_Name</label>
            <input
              type="text"
              className="form-control"
              id="phn"
              aria-describedby="emailHelp"
              name="txt"
              value={this.state.txt}
              onChange={this.handleChange}
            />
          </div>
          <div className="form-group">
            <label htmlFor="an">Album_Name</label>
            <input
              type="text"
              className="form-control"
              id="an"
              aria-describedby="emailHelp"
              name="aname"
              value={this.state.nick}
              onChange={this.handleChange}
            />
          </div>
          <div className="form-group">
            <label htmlFor="sloc">Song_Location</label>
            <input
              type="password"
              className="form-control"
              id="sloc"
              name="loc"
              value={this.state.pwd}
              onChange={this.handleChange}
            />
          </div>

          <button type="submit" className="btn btn-primary">
            Submit
          </button>
        </form>
      </div>
    );
  }
}
