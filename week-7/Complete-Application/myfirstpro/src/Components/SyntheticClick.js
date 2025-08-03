import React from 'react';

function SyntheticClick() {
  const handleClick = (event) => {
    console.log(event); // SyntheticEvent object
    alert('I was clicked');
  };

  return (
    <div style={{ marginTop: '20px' }}>
      <h2>🖱️ Synthetic Event</h2>
      <button onClick={handleClick}>OnPress</button>
    </div>
  );
}

export default SyntheticClick;
