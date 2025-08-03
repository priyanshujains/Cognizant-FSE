import React, { useState } from 'react';

function CurrencyConvertor() {
  const [rupees, setRupees] = useState('');
  const [euros, setEuros] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    const conversionRate = 0.011; // 1 INR = 0.011 EUR approx
    const result = parseFloat(rupees) * conversionRate;
    setEuros(result.toFixed(2));
  };

  return (
    <div style={{ marginTop: '20px' }}>
      <h2>💱 Currency Convertor (INR ➝ EUR)</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="number"
          placeholder="Enter amount in ₹"
          value={rupees}
          onChange={(e) => setRupees(e.target.value)}
          required
        />
        <button type="submit">Convert</button>
      </form>
      {euros && (
        <p>
          <strong>Euro Amount:</strong> €{euros}
        </p>
      )}
    </div>
  );
}

export default CurrencyConvertor;
