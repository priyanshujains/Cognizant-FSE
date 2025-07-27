import React from 'react';
import Home from './Components/Home';
import About from './Components/About';
import Contact from './Components/Contact';
import CalculateScore from './Components/CalculateScore';
import Posts from './Posts';
import CohortDetails from './CohortDetails';

function App() {

    const cohorts = [
    {
      name: 'React Batch 1',
      status: 'ongoing',
      startDate: '2025-06-01',
      endDate: '2025-07-30',
    },
    {
      name: 'Java Fullstack',
      status: 'completed',
      startDate: '2025-04-01',
      endDate: '2025-06-15',
    },
  ];




  return (
   

    <div>
      {cohorts.map((cohort, index) => (
        <CohortDetails key={index} cohort={cohort} />
      ))}
    </div>
  );
}

export default App;
