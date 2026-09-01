import { useState } from 'react'
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom'
import './App.css'

// Dealer pages
import Rentals from './pages/dealer/Rentals'
import Maintenance from './pages/dealer/Maintenance'
import TopPerformingRigs from './pages/dealer/TopPerformingRigs'
import RequestNewRig from './pages/dealer/RequestNewRig'

// Customer pages
import MyEquipment from './pages/customer/MyEquipment'

export default function App() {
  const [role, setRole] = useState('dealer')

  const switchRole = (newRole) => {
    setRole(newRole)
  }

  return (
    <Router>
      <div className="app">
        <nav className="navbar">
          <div className="navbar-brand">
            <h2>CAT Smart Rental</h2>
          </div>
          <div className="navbar-role-selector">
            <button
              className={`role-btn ${role === 'dealer' ? 'active' : ''}`}
              onClick={() => switchRole('dealer')}
            >
              Dealer/Admin
            </button>
            <button
              className={`role-btn ${role === 'customer' ? 'active' : ''}`}
              onClick={() => switchRole('customer')}
            >
              Customer
            </button>
          </div>
        </nav>

        <div className="app-container">
          {role === 'dealer' && (
            <aside className="sidebar">
              <nav className="sidebar-nav">
                <Link to="/rentals" className="nav-link">Rentals</Link>
                <Link to="/maintenance" className="nav-link">Maintenance</Link>
                <Link to="/top-rigs" className="nav-link">Top Performing Rigs</Link>
                <Link to="/request-rig" className="nav-link">Request New Rig</Link>
              </nav>
            </aside>
          )}

          {role === 'customer' && (
            <aside className="sidebar">
              <nav className="sidebar-nav">
                <Link to="/my-equipment" className="nav-link">My Equipment</Link>
              </nav>
            </aside>
          )}

          <main className="main-content">
            <Routes>
              {role === 'dealer' && (
                <>
                  <Route path="/rentals" element={<Rentals />} />
                  <Route path="/maintenance" element={<Maintenance />} />
                  <Route path="/top-rigs" element={<TopPerformingRigs />} />
                  <Route path="/request-rig" element={<RequestNewRig />} />
                  <Route path="/" element={<Rentals />} />
                </>
              )}
              {role === 'customer' && (
                <>
                  <Route path="/my-equipment" element={<MyEquipment />} />
                  <Route path="/" element={<MyEquipment />} />
                </>
              )}
            </Routes>
          </main>
        </div>
      </div>
    </Router>
  )
}
