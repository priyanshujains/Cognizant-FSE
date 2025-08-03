import React from 'react';

const IndianPlayers = () => {

  const allPlayers = ['Kohli', 'Rohit', 'Gill', 'Pant', 'Iyer', 'Jadeja'];
  const oddTeam = allPlayers.filter((_, index) => index % 2 !== 0);
  const evenTeam = allPlayers.filter((_, index) => index % 2 === 0);

  
  const T20Players = ['Hardik', 'Bumrah'];
  const RanjiPlayers = ['Pujara', 'Rahane'];
  const mergedPlayers = [...T20Players, ...RanjiPlayers];

  return (
    <div>
      <h2>Even Team Players</h2>
      <ul>{evenTeam.map((name, i) => <li key={i}>{name}</li>)}</ul>

      <h2>Odd Team Players</h2>
      <ul>{oddTeam.map((name, i) => <li key={i}>{name}</li>)}</ul>

      <h2>Merged Players (T20 + Ranji)</h2>
      <ul>{mergedPlayers.map((name, i) => <li key={i}>{name}</li>)}</ul>
    </div>
  );
};

export default IndianPlayers;
