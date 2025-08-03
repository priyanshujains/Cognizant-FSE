import React from 'react';

function WelcomeButton() {
  const handleClick = (message) => {
    alert(`Message: ${message}`);
  };

  return (
    <div style={{ marginTop: '20px' }}>
      <h2>👋 Say Welcome</h2>
      <button onClick={() => handleClick('Welcome')}>Say Welcome</button>
    </div>
  );
}

export default WelcomeButton;
