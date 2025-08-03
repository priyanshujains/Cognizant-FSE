import React, { useContext } from 'react';
import ThemeContext from './ThemeContext';

const EmployeeCard = ({ employee }) => {
  const theme = useContext(ThemeContext); // Using context

  const buttonClass = theme === 'dark' ? 'btn-dark' : 'btn-light';

  return (
    <div style={{ margin: '10px 0' }}>
      <h3>{employee.name}</h3>
      <p>{employee.designation}</p>
      <button className={buttonClass}>View Profile</button>
    </div>
  );
};

export default EmployeeCard;
