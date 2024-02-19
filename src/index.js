import React from 'react';
import { createRoot } from 'react-dom';
import AddUserForm from './frontend/AddUserForm';

const App = () => {
  return (
    <div>
      <h1>Hello, you!</h1>
      <AddUserForm/>
    </div>
  );
};
createRoot(document.getElementById('root')).render(<App />);
//ReactDOM.render(<App />, document.getElementById('root'));

// import React from 'react';
// import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
// import AddUserForm from './frontend/AddUserForm';


// const App = () => {
//   return (
//     <Router>
//       <Routes>
//         <Route path="/add-user" element={<AddUserForm />} />
//         {/* Andra routes */}
//       </Routes>
//     </Router>
//   );
// };

// export default App;
