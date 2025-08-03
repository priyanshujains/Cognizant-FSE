import React, { Component } from 'react';
import ThemeContext from './ThemeContext';
import EmployeeList from './EmployeeList';

class App extends Component {
  state = {
    theme: 'dark' 
  };

  render() {
    return (
      <ThemeContext.Provider value={this.state.theme}>
        <div>
          <h1>Employee Management</h1>
          <EmployeeList />
        </div>
      </ThemeContext.Provider>
    );
  }
}

export default App;
