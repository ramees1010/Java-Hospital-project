import { useEffect, useState } from 'react'
import API_URL from '../services/Api'

function Patients() {

  const role = sessionStorage.getItem('role')

  const [patients, setPatients] = useState([])
  const [showForm, setShowForm] = useState(false)

  const [patientTime, setPatientTime] = useState('')
  const [age, setAge] = useState('')
  const [gender, setGender] = useState('male')
  const [phone, setPhone] = useState('')
  const [email, setEmail] = useState('')

  const loadPatients = () => {

    const url =
      role === 'ROLE_PATIENT'
        ? `${API_URL}/patients/me`
        : `${API_URL}/patients`

    fetch(url, {
      credentials: 'include'
    })
      .then(response => {

        if (!response.ok) {
          throw new Error('Failed to load patient')
        }

        return response.json()
      })
      .then(data => {

        if (role === 'ROLE_PATIENT') {

          if (data) {
            setPatients([data])
          } else {
            setPatients([])
          }

        } else {

          setPatients(data)

        }

      })
      .catch(error => {
        console.log(error)
        setPatients([])
      })

  }

  useEffect(() => {
    loadPatients()
  }, [])

  const addPatient = () => {

    const patient = {
      patientTime: patientTime,
      age: Number(age),
      gender: gender,
      phone: phone,
      email: email
    }

    const url =
      role === 'ROLE_PATIENT'
        ? `${API_URL}/patients/me`
        : `${API_URL}/patients/add`

    fetch(url, {
      method: 'POST',
      credentials: 'include',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(patient)
    })
      .then(response => {

        if (!response.ok) {
          throw new Error('Failed to add patient')
        }

        alert('Patient added')

        setPatientTime('')
        setAge('')
        setGender('male')
        setPhone('')
        setEmail('')
        setShowForm(false)

        loadPatients()
      })
      .catch(error => {
        alert(error.message)
      })
  }

  const updatePatient = (id) => {

    fetch(`${API_URL}/patients/update/${id}`, {
      method: 'PUT',
      credentials: 'include'
    })
      .then(response => {

        if (!response.ok) {
          throw new Error('Failed to update patient')
        }

        alert('Patient updated')

        loadPatients()
      })
      .catch(error => {
        alert(error.message)
      })
  }

  const deletePatient = (id) => {

    if (!window.confirm('Delete this patient?')) {
      return
    }

    fetch(`${API_URL}/patients/delete/${id}`, {
      method: 'DELETE',
      credentials: 'include'
    })
      .then(response => {

        if (!response.ok) {
          throw new Error('Failed to delete patient')
        }

        alert('Patient deleted')

        loadPatients()
      })
      .catch(error => {
        alert(error.message)
      })
  }

  return (
    <div>

      <div className="page-header">

        <h1>
          {role === 'ROLE_PATIENT'
            ? 'My Profile'
            : 'Patients'}
        </h1>

        {role === 'ROLE_ADMIN' && (
          <button onClick={() => setShowForm(true)}>
            Add Patient
          </button>
        )}

        {role === 'ROLE_PATIENT' && patients.length === 0 && (
          <button onClick={() => setShowForm(true)}>
            Add Patient
          </button>
        )}

      </div>

      {showForm && (

        <div className="form-box">

          <h3>Register Patient</h3>

          <input
            type="time"
            value={patientTime}
            onChange={(e) => setPatientTime(e.target.value)}
          />

          <input
            type="number"
            placeholder="Age"
            value={age}
            onChange={(e) => setAge(e.target.value)}
          />

          <select
            value={gender}
            onChange={(e) => setGender(e.target.value)}
          >
            <option value="male">Male</option>
            <option value="female">Female</option>
            <option value="others">Others</option>
          </select>

          <input
            type="text"
            placeholder="Phone"
            value={phone}
            onChange={(e) => setPhone(e.target.value)}
          />

          <input
            type="email"
            placeholder="Email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />

          <button onClick={addPatient}>
            Save
          </button>

          <button
            className="cancel-button"
            onClick={() => setShowForm(false)}
          >
            Cancel
          </button>

        </div>

      )}

      <table>

        <thead>

          <tr>
            <th>ID</th>
            <th>Time</th>
            <th>Age</th>
            <th>Gender</th>
            <th>Phone</th>
            <th>Email</th>

            {role === 'ROLE_ADMIN' && (
              <th>Actions</th>
            )}

          </tr>

        </thead>

        <tbody>

          {patients.map(patient => (

            <tr key={patient.pId}>

              <td>{patient.pId}</td>
              <td>{patient.patientTime}</td>
              <td>{patient.age}</td>
              <td>{patient.gender}</td>
              <td>{patient.phone}</td>
              <td>{patient.email}</td>

              {role === 'ROLE_ADMIN' && (
                <td>

                  <button
                    onClick={() =>
                      updatePatient(patient.pId)
                    }
                  >
                    Update
                  </button>

                  <button
                    className="delete-button"
                    onClick={() =>
                      deletePatient(patient.pId)
                    }
                  >
                    Delete
                  </button>

                </td>
              )}

            </tr>

          ))}

        </tbody>

      </table>

    </div>
  )
}

export default Patients