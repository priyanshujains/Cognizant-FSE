import React from 'react';

const ListofPlayers = () => {
  const players = [
    { name: 'Virat Kohli', score: 85 },
    { name: 'Rohit Sharma', score: 45 },
    { name: 'KL Rahul', score: 60 },
    { name: 'Shubman Gill', score: 74 },
    { name: 'Hardik Pandya', score: 90 },
    { name: 'Ravindra Jadeja', score: 38 },
    { name: 'Jasprit Bumrah', score: 50 },
    { name: 'Rishabh Pant', score: 79 },
    { name: 'Mohammed Siraj', score: 55 },
    { name: 'Axar Patel', score: 65 },
    { name: 'Shreyas Iyer', score: 83 }
  ];

  // Using map to display
  const playerList = players.map((player, index) => (
    <li key={index}>
      {player.name} - {player.score}
    </li>
  ));

  // Arrow function to filter players below score 70
  const lowScorers = players.filter(player => player.score < 70);

  return (
    <div>
      <h2>All Players</h2>
      <ul>{playerList}</ul>

      <h2>Players with score below 70</h2>
      <ul>
        {lowScorers.map((p, i) => (
          <li key={i}>{p.name} - {p.score}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
