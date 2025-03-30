import { Route, Routes } from 'react-router-dom'
import './App.css'

import Sidebar from './components/layout/Sidebar/Sidebar'
import HomePage from './components/layout/HomePage/HomePage';
import Header from './components/layout/Header/Header';
import Board from './components/layout/Board/Board';
import Saves from './components/layout/Saves/Saves';



function App() {

  return (
    <>
      <Header />
      <div className='main flex flex-row'>
        <Sidebar />
        <div className='main-page-section'>
          <Routes>
            <Route path="/" element={<HomePage />} />
            <Route path="/questions" element={<Board />} />
            <Route path="/saves" element={<Saves />} />
            <Route path="/*" element={<h1>존재하지 않는 페이지 요청입니다.</h1>} />
          </Routes>
        </div>

      </div>
    </>
  );
};

export default App;
