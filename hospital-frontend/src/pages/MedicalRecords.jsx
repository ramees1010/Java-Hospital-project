import { useEffect, useState } from 'react'
import API_URL from '../services/Api'

function MedicalRecords() {

    const role = sessionStorage.getItem('role')

  const [records, setRecords] = useState([])
  const [showForm, setShowForm] = useState(false)

  const [diagnosis, setDiagnosis] = useState('')
  const [treatment, setTreatment] = useState('')
  const [visitDate, setVisitDate] = useState('')
  const [patientId, setPatientId] = useState('')
  const [doctorId, setDoctorId] = useState('')

  const loadRecords = () => {

    fetch(`${API_URL}/medicalrecords`,{
          credentials: 'include'
    })
      .then(response => response.json())
      .then(data => {
        setRecords(data)
      })
      .catch(error => console.log(error))

  }

  useEffect(() => {
    loadRecords()
  }, [])

  const addMedicalRecord = () => {

    const record = {
      diagnosis: diagnosis,
      treatment: treatment,
      visitDate: visitDate,

      patient: {
        pId: Number(patientId)
      },

      doctor: {
        id: Number(doctorId)
      }
    }

    fetch(`${API_URL}/medicalrecords/add`, {
      method: 'POST',
      credentials: 'include',

      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(record)
    })
      .then(response => {

        if (!response.ok) {
          throw new Error('Failed to add medical record')
        }

        alert('Medical record added')

        setDiagnosis('')
        setTreatment('')
        setVisitDate('')
        setPatientId('')
        setDoctorId('')
        setShowForm(false)

        loadRecords()
      })
      .catch(error => {
        alert(error.message)
      })
  }

  return (
    <div>

      <div className="page-header">

        <h1>Medical Records</h1>
         {(role === 'ROLE_ADMIN' || role === 'ROLE_DOCTOR') && (
        <button onClick={() => setShowForm(true)}>
         Add Medical Record
         </button>
         )}

      </div>

      {showForm && (

        <div className="form-box">

          <h3>Add Medical Record</h3>

          <input
            type="text"
            placeholder="Diagnosis"
            value={diagnosis}
            onChange={(e) =>
              setDiagnosis(e.target.value)
            }
          />

          <input
            type="text"
            placeholder="Treatment"
            value={treatment}
            onChange={(e) =>
              setTreatment(e.target.value)
            }
          />

          <input
            type="date"
            value={visitDate}
            onChange={(e) =>
              setVisitDate(e.target.value)
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

          <input
            type="number"
            placeholder="Doctor ID"
            value={doctorId}
            onChange={(e) =>
              setDoctorId(e.target.value)
            }
          />

          <button onClick={addMedicalRecord}>
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
            <th>Diagnosis</th>
            <th>Treatment</th>
            <th>Visit Date</th>
            <th>Patient</th>
            <th>Doctor</th>
          </tr>

        </thead>

        <tbody>

          {records.map(record => (

            <tr key={record.recordId}>

              <td>
                {record.recordId}
              </td>

              <td>
                {record.diagnosis}
              </td>

              <td>
                {record.treatment}
              </td>

              <td>
                {record.visitDate}
              </td>

              <td>
                {record.patient?.pId}
              </td>

              <td>
                {record.doctor?.id}
              </td>

            </tr>

          ))}

        </tbody>

      </table>

    </div>
  )
}

export default MedicalRecords