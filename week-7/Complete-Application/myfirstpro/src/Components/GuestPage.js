import React from 'react';

const GuestPage = () => {
  return (
    <div>
      <h2>✈️ Welcome, Guest!</h2>
      <p>Please login to book tickets.</p>
      <h3>📋 Flight Listings</h3>
      <ul>
        <li>Flight: AI-101 | From: Delhi | To: Mumbai | Time: 10:00 AM</li>
        <li>Flight: AI-202 | From: Mumbai | To: Bangalore | Time: 1:00 PM</li>
        <li>Flight: AI-303 | From: Kolkata | To: Chennai | Time: 5:00 PM</li>
      </ul>
    </div>
  );
};

export default GuestPage;
