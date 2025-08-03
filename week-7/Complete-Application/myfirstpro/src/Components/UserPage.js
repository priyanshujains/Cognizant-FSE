import React from 'react';

const UserPage = () => {
  return (
    <div>
      <h2>👋 Welcome Back, User!</h2>
      <h3>📋 Flight Listings</h3>
      <ul>
        <li>
          Flight: AI-101 | From: Delhi | To: Mumbai | Time: 10:00 AM{' '}
          <button>Book</button>
        </li>
        <li>
          Flight: AI-202 | From: Mumbai | To: Bangalore | Time: 1:00 PM{' '}
          <button>Book</button>
        </li>
        <li>
          Flight: AI-303 | From: Kolkata | To: Chennai | Time: 5:00 PM{' '}
          <button>Book</button>
        </li>
      </ul>
    </div>
  );
};

export default UserPage;
