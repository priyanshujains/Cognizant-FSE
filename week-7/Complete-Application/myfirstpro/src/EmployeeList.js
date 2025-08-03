import React from 'react';
import EmployeeCard from './EmployeeCard';

const EmployeeList = () => {
  const employees = [
    { id: 1, name: 'Alice', designation: 'Developer' },
    { id: 2, name: 'Bob', designation: 'Tester' }
  ];

  return (
    <div>
      <h2>Employees</h2>
      {employees.map((emp) => (
        <EmployeeCard key={emp.id} employee={emp} />
      ))}
    </div>
  );
};

export default EmployeeList;
