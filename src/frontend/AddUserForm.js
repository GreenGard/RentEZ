// eslint-disable-next-line
import React, { useState, useEffect } from 'react';
import axios from 'axios';

const AddUserForm = () => {
  const [lastname, setLastName] = useState('');  
  const [name, setName] = useState('');
  const [username, setuserName] = useState('');
  const [email, setEmail] = useState('');
  const [city, setCity] = useState('');
  const [company, setCompany] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('/api/users', { lastname, name, username, email, city,company, password });
      console.log(response.data); 
    } catch (error) {
      console.error(error + "add user went wrong");
    }
  };

  return (
    <form onSubmit={handleSubmit}>
     <input
        type="text"
        placeholder="Lastname"
        value={lastname}
        onChange={(e) => setLastName(e.target.value)}
      />
      <input
        type="text"
        placeholder="Name"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />
        <input
        type="text"
        placeholder="Username"
        value={username}
        onChange={(e) => setuserName(e.target.value)}
      />
    
      <input
        type="email"
        placeholder="Email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />
      <input
        type="text"
        placeholder="city"
        value={city}
        onChange={(e) => setCity(e.target.value)}
      />
      <input
        type="text"
        placeholder="company"
        value={company}
        onChange={(e) => setCompany(e.target.value)}
      />
    
      <input
        type="password"
        placeholder="Password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />
      <button type="submit">Add User</button>
    </form>
  );
};

export default AddUserForm;
