import { Routes, Route, Navigate } from 'react-router-dom'

import Sidebar from './components/Sidebar'
import Navbar from './components/Navbar'

import Landing from './pages/Landing'
import Dashboard from './pages/Dashboard'
import Departments from './pages/Departments'
import Doctors from './pages/Doctors'
import Patients from './pages/Patients'
import Appointments from './pages/Appointments'
import MedicalRecords from './pages/MedicalRecords'
import Prescriptions from './pages/Prescriptions'
import Login from './pages/Login'
import About from './pages/About'
import Signup from './pages/Signup'

function App() {

  const loggedIn = sessionStorage.getItem('loggedIn')
  const role = sessionStorage.getItem('role')

  return (

    <Routes>
      

      <Route
        path="/"
        element={<Landing />}
      />
       <Route
        path="about"
        element={<About />}
      />

      {/* Public Login Page */}
      <Route
        path="/signup"
        element={<Signup/>}
      />
      <Route
        path="/login"
        element={<Login />}
      />

      {/* Protected Pages */}
      {loggedIn === 'true' && (

        <Route
          path="/*"
          element={

            <div className="app">

              <Sidebar />

              <div className="main">

                <Navbar />

                <div className="content">

                  <Routes>

                    {/* ADMIN ONLY */}
                    {role === 'ROLE_ADMIN' && (
                      <>

                        <Route
                          path="/dashboard"
                          element={<Dashboard />}
                        />

                        <Route
                          path="/departments"
                          element={<Departments />}
                        />

                        <Route
                          path="/doctors"
                          element={<Doctors />}
                        />

                      </>
                    )}

                    {/* ADMIN + PATIENT */}
                    {(role === 'ROLE_ADMIN' ||
                      role === 'ROLE_PATIENT') && (

                      <Route
                        path="/patients"
                        element={<Patients />}
                      />

                    )}

                    {/* ADMIN + DOCTOR + PATIENT */}
                    <Route
                      path="/appointments"
                      element={<Appointments />}
                    />

                    <Route
                      path="/medical-records"
                      element={<MedicalRecords />}
                    />

                    <Route
                      path="/prescriptions"
                      element={<Prescriptions />}
                    />

                    {/* DEFAULT PAGE */}
                    <Route
                      path="*"
                      element={
                        role === 'ROLE_ADMIN'
                          ? <Navigate to="/dashboard" />
                          : <Navigate to="/appointments" />
                      }
                    />

                  </Routes>

                </div>

              </div>

            </div>

          }
        />

      )}

      {loggedIn !== 'true' && (
        <Route
          path="*"
          element={<Navigate to="/login" />}
        />
      )}

    </Routes>
  )
}

export default App