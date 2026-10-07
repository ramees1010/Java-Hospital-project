import { useEffect, useState } from 'react'
import API_URL from '../services/Api'


function Doctors() {

  const [doctors, setDoctors] = useState([])
  const [showForm, setShowForm] = useState(false)

  const [doctorName, setDoctorName] = useState('')
  const [specialization, setSpecialization] = useState('')
  const [availableDays, setAvailableDays] = useState('')
  const [departmentId, setDepartmentId] = useState('')

  const loadDoctors = () => {

    fetch(`${API_URL}/doctors`, {
      credentials: 'include'
    })
      .then(response => response.json())
      .then(data => {
        setDoctors(data)
      })
      .catch(error => console.log(error))

  }

  useEffect(() => {
    loadDoctors()
  }, [])

  const addDoctor = () => {

    if (
      doctorName.trim() === '' ||
      specialization.trim() === '' ||
      availableDays.trim() === '' ||
      departmentId === ''
    ) {
      alert('Fill all fields')
      return
    }

    const doctor = {
      doctorName: doctorName,
      specialization: specialization,
      availableDays: availableDays,
      department: {
        deptId: Number(departmentId)
      }
    }

    fetch(`${API_URL}/doctors/add`, {
      method: 'POST',
      credentials: 'include',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(doctor)
    })
      .then(response => {

        if (!response.ok) {
          throw new Error('Failed to add doctor')
        }

        alert('Doctor added')

        setDoctorName('')
        setSpecialization('')
        setAvailableDays('')
        setDepartmentId('')
        setShowForm(false)

        loadDoctors()
      })
      .catch(error => {
        alert(error.message)
      })
  }

  const updateDoctor = (id) => {

    fetch(`${API_URL}/doctors/update/${id}`, {
      method: 'PUT',
      credentials: 'include'
    })
      .then(response => {

        if (!response.ok) {
          throw new Error('Failed to update doctor')
        }

        alert('Doctor updated')

        loadDoctors()
      })
      .catch(error => {
        alert(error.message)
      })
  }

  const deleteDoctor = (id) => {

    if (!window.confirm('Delete this doctor?')) {
      return
    }

    fetch(`${API_URL}/doctors/delete/${id}`, {
      method: 'DELETE',
      credentials: 'include'
    })
      .then(response => {

        if (!response.ok) {
          throw new Error('Failed to delete doctor')
        }

        alert('Doctor deleted')

        loadDoctors()
      })
      .catch(error => {
        alert(error.message)
      })
  }

  return (
    <div>

      <div className="page-header">

        <h1>Doctors</h1>

        <button onClick={() => setShowForm(true)}>
          Add Doctor
        </button>

      </div>

      {showForm && (

        <div className="form-box">

          <h3>Add Doctor</h3>

          <input
            type="text"
            placeholder="Doctor name"
            value={doctorName}
            onChange={(e) => setDoctorName(e.target.value)}
          />

          <input
            type="text"
            placeholder="Specialization"
            value={specialization}
            onChange={(e) => setSpecialization(e.target.value)}
          />

          <input
            type="text"
            placeholder="Available days"
            value={availableDays}
            onChange={(e) => setAvailableDays(e.target.value)}
          />

          <input
            type="number"
            placeholder="Department ID"
            value={departmentId}
            onChange={(e) => setDepartmentId(e.target.value)}
          />

          <button onClick={addDoctor}>
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
            <th>Name</th>
            <th>Specialization</th>
            <th>Available Days</th>
            <th>Department</th>
            <th>Actions</th>
          </tr>

        </thead>

        <tbody>

          {doctors.map(doctor => (

            <tr key={doctor.id}>

              <td>{doctor.id}</td>

              <td>{doctor.doctorName}</td>

              <td>{doctor.specialization}</td>

              <td>{doctor.availableDays}</td>

              <td>
                {doctor.department?.deptId}
              </td>

              <td>

                <button
                  onClick={() =>
                    updateDoctor(doctor.id)
                  }
                >
                  Update
                </button>

                <button
                  className="delete-button"
                  onClick={() =>
                    deleteDoctor(doctor.id)
                  }
                >
                  Delete
                </button>

              </td>

            </tr>

          ))}

        </tbody>

      </table>

    </div>
  )
}

export default Doctors