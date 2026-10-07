import { NavLink } from 'react-router-dom'

function Sidebar() {

  const role = sessionStorage.getItem('role')

  return (
    <aside className="sidebar">

      <div className="logo">
        MediCare
      </div>

      <nav>

        {role === 'ROLE_ADMIN' && (
          <>
            <NavLink to="/dashboard">
              Dashboard
            </NavLink>

            <NavLink to="/departments">
              Departments
            </NavLink>

            <NavLink to="/doctors">
              Doctors
            </NavLink>

            <NavLink to="/patients">
              Patients
            </NavLink>
          </>
        )}

        {role === 'ROLE_PATIENT' && (
          <NavLink to="/patients">
            My Profile
          </NavLink>
        )}

        <NavLink to="/appointments">
          Appointments
        </NavLink>

        <NavLink to="/medical-records">
          Medical Records
        </NavLink>

        <NavLink to="/prescriptions">
          Prescriptions
        </NavLink>

      </nav>

    </aside>
  )
}

export default Sidebar