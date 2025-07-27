import React from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore({ name, school, total, goal }) {
  const percentage = ((total / (goal * 100)) * 100).toFixed(2);

  return (
    <div className="container">
      <h2 className="heading">Student Details:</h2>

      <div className="detail">
        <span className="name-label">Name:</span>{' '}
        <span className="name-value">{name}</span>
      </div>

      <div className="detail">
        <span className="school-label">School:</span>{' '}
        <span className="school-value">{school}</span>
      </div>

      <div className="detail">
        <span className="total-label">Total:</span>{' '}
        <span className="total-value">{total} Marks</span>
      </div>

      <div className="detail">
        <span className="score-label">Score:</span>{' '}
        <span className="score-value">{percentage}%</span>
      </div>
    </div>
  );
}

export default CalculateScore;
