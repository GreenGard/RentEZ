import React from 'react';
import { createRoot } from 'react-dom';
//import App from './App';
import AddUserForm from './frontend/AddUserForm';
import './input.css';
//import reportWebVitals from './reportWebVitals';

const App = () => {
  return (
    <div className="bg-gray-600 h-screen text-white flex justify-center items-center">
      <h1 className="text-3xl font-bold">Hello Tailwind CSS!</h1>
      <AddUserForm/>
    </div>
  );
};
createRoot(document.getElementById('root')).render(<App />);
