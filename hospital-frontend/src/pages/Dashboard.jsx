import { Link } from 'react-router-dom'

function Dashboard() {
  return (
    <div className="dashboard">

      <div className="dashboard-header">
        <div>
          <h1>Dashboard</h1>
          <p>Hospital Management System</p>
        </div>
      </div>

      <div className="dashboard-cards">

        <Link to="/departments" className="dashboard-card">
          <div className="card-icon">🏥</div>
          <div>
            <h3>Departments</h3>
            <p>Manage hospital departments</p>
          </div>
        </Link>

        <Link to="/doctors" className="dashboard-card">
          <div className="card-icon">👨‍⚕️</div>
          <div>
            <h3>Doctors</h3>
            <p>Manage doctors and specialists</p>
          </div>
        </Link>

        <Link to="/patients" className="dashboard-card">
          <div className="card-icon">🧑‍🤝‍🧑</div>
          <div>
            <h3>Patients</h3>
            <p>Register and manage patients</p>
          </div>
        </Link>

        <Link to="/appointments" className="dashboard-card">
          <div className="card-icon">📅</div>
          <div>
            <h3>Appointments</h3>
            <p>Book and manage appointments</p>
          </div>
        </Link>

        <Link to="/medical-records" className="dashboard-card">
          <div className="card-icon">📋</div>
          <div>
            <h3>Medical Records</h3>
            <p>Manage patient medical records</p>
          </div>
        </Link>

        <Link to="/prescriptions" className="dashboard-card">
          <div className="card-icon">💊</div>
          <div>
            <h3>Prescriptions</h3>
            <p>Manage patient prescriptions</p>
          </div>
        </Link>

      </div>

    </div>
  )
}

export default Dashboard