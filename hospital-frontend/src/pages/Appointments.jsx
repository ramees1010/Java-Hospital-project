import { useEffect, useState } from 'react'
import API_URL from '../services/Api'

function Appointments() {

  const role = sessionStorage.getItem('role')

  const [appointments, setAppointments] = useState([])
  const [showForm, setShowForm] = useState(false)

  const [appointDateTime, setAppointDateTime] = useState('')
  const [appointStatus, setAppointStatus] = useState('Booked')
  const [doctorId, setDoctorId] = useState('')
  const [patientId, setPatientId] = useState('')

  const loadAppointments = () => {

    fetch(`${API_URL}/appointments`, {
      credentials: 'include'
    })
      .then(response => response.json())
      .then(data => {
        setAppointments(data)
      })
      .catch(error => console.log(error))

  }

  useEffect(() => {
    loadAppointments()
  }, [])

  const addAppointment = () => {

    const appointment = {
      appointDateTime: appointDateTime,
      appointStatus: appointStatus,
      doctor: {
        id: Number(doctorId)
      },
      patient: {
        pId: Number(patientId)
      }
    }

    fetch(`${API_URL}/appointments/add`, {
      method: 'POST',
      credentials: 'include',

      headers: {
        'Content-Type': 'application/json'
      },

      body: JSON.stringify(appointment)
    })
      .then(response => {

        if (!response.ok) {
          throw new Error('Failed to book appointment')
        }

        alert('Appointment booked')

        setAppointDateTime('')
        setAppointStatus('Booked')
        setDoctorId('')
        setPatientId('')
        setShowForm(false)

        loadAppointments()
      })
      .catch(error => {
        alert(error.message)
      })
  }

  const cancelAppointment = (id) => {

    if (!window.confirm('Cancel this appointment?')) {
      return
    }

    fetch(`${API_URL}/appointments/cancel/${id}`, {
      method: 'PUT',
      credentials: 'include'
    })
      .then(response => {

        if (!response.ok) {
          throw new Error('Failed to cancel appointment')
        }

        alert('Appointment cancelled')

        loadAppointments()
      })
      .catch(error => {
        alert(error.message)
      })
  }

  const updateStatus = (id) => {

    const status = prompt(
      'Enter status: Booked, confirmed, cancelled'
    )

    if (!status) {
      return
    }

    fetch(`${API_URL}/appointments/status/${id}`, {
      method: 'PUT',
      credentials: 'include',

      headers: {
        'Content-Type': 'application/json'
      },

      body: JSON.stringify({
        appointStatus: status
      })
    })
      .then(response => {

        if (!response.ok) {
          throw new Error('Failed to update status')
        }

        alert('Status updated')

        loadAppointments()
      })
      .catch(error => {
        alert(error.message)
      })
  }

  return (
    <div>

      <div className="page-header">

        <h1>
          Appointments
        </h1>

        {role !== 'ROLE_DOCTOR' && (
          <button onClick={() => setShowForm(true)}>
            Book Appointment
          </button>
        )}

      </div>

      {showForm && (

        <div className="form-box">

          <h3>
            Book Appointment
          </h3>

          <input
            type="datetime-local"
            value={appointDateTime}
            onChange={(e) =>
              setAppointDateTime(e.target.value)
            }
          />

          <select
            value={appointStatus}
            onChange={(e) =>
              setAppointStatus(e.target.value)
            }
          >
            <option value="Booked">
              Booked
            </option>

            <option value="confirmed">
              Confirmed
            </option>

            <option value="cancelled">
              Cancelled
            </option>
          </select>

          <input
            type="number"
            placeholder="Doctor ID"
            value={doctorId}
            onChange={(e) =>
              setDoctorId(e.target.value)
            }
          />

          <input
            type="number"
            placeholder="Patient ID"
            value={patientId}
            onChange={(e) =>
              setPatientId(e.target.value)
            }
          />

          <button onClick={addAppointment}>
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

            <th>
              ID
            </th>

            <th>
              Date & Time
            </th>

            <th>
              Status
            </th>

            <th>
              Doctor
            </th>

            <th>
              Patient
            </th>

            <th>
              Actions
            </th>

          </tr>

        </thead>

        <tbody>

          {appointments.map(appointment => (

            <tr key={appointment.appointId}>

              <td>
                {appointment.appointId}
              </td>

              <td>
                {appointment.appointDateTime}
              </td>

              <td>
                {appointment.appointStatus}
              </td>

              <td>
                {appointment.doctor?.id}
              </td>

              <td>
                {appointment.patient?.pId}
              </td>

              <td>

                {role !== 'ROLE_DOCTOR' && (
                  <>
                    <button
                      onClick={() =>
                        updateStatus(
                          appointment.appointId
                        )
                      }
                    >
                      Update Status
                    </button>

                    <button
                      className="delete-button"
                      onClick={() =>
                        cancelAppointment(
                          appointment.appointId
                        )
                      }
                    >
                      Cancel
                    </button>
                  </>
                )}

              </td>

            </tr>

          ))}

        </tbody>

      </table>

    </div>
  )
}

export default Appointments